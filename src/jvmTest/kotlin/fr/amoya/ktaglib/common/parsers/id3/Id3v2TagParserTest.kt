package fr.amoya.ktaglib.common.parsers.id3

import fr.amoya.ktaglib.common.tags.Tag
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import java.lang.System.gc
import kotlin.io.path.*
import kotlin.test.assertEquals


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

@ExperimentalUnsignedTypes
@ExperimentalPathApi
internal class Id3v2TagParserTest
{

  /*
  ** Error Checking
  */
  @ParameterizedTest(name = "Should throw an error : {0}")
  @Order(0)
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun `should throw an error`(filename: String, fileType: String)
  {
    val fPath = Path("src", "commonTest", "resources", filename)
    Assumptions.assumingThat(!(fPath.exists() && fPath.isRegularFile() && fPath.isReadable()))
    {
      assertThrows<IllegalArgumentException> { Tag.getTag(fPath.absolutePathString()) }
    }
    Assumptions.assumingThat(!fileType.contains("ID3V2"))
    {
      assertThrows<NotImplementedError> { Tag.getTag(fPath.absolutePathString()) }
    }
  }

  /*
  ** Actual Parsing Check
  */
  @ParameterizedTest(name = "Should Parse : {0}")
  @Order(1)
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun `should parse tag`(
    filename: String,
    fileType: String
  )
  {
    val fPath = Path("src", "commonTest", "resources", filename)
    Assumptions.assumeTrue(fileType.contains("ID3V23") && fPath.exists() && fPath.isRegularFile() && fPath.isReadable())
    val tag = Tag.getTag(fPath.absolutePathString())
    assertEquals(fileType, tag.tagVersion.specification)
  }

  @AfterEach
  fun cleanUp()
  {
    gc()
  }

}
