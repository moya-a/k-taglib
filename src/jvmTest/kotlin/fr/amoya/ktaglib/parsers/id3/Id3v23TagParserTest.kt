package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.tags.Tag
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
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

@ExperimentalPathApi
internal class Id3v23TagParserTest
{

  @ParameterizedTest(name = "Should Parse : {0}")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun `should parse tag`(filename: String, fileType: String)
  {
    val fPath = Path("src", "commonTest", "resources", filename)
    Assumptions.assumeTrue(fileType.contains("ID3V2") && fPath.exists() && fPath.isRegularFile() && fPath.isReadable())
    val tag = Tag.getTag(fPath.absolutePathString())
    assertEquals(fileType, tag.type.specification)
  }


  @ParameterizedTest(name = "Should throw not implemented : {0}")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun `should throw not implemented`(filename: String, fileType: String)
  {
    val fPath = Path("src", "commonTest", "resources", filename)

    Assumptions.assumeFalse(fileType.contains("ID3V2"))
    assertThrows<NotImplementedError> { Tag.getTag(fPath.absolutePathString()) }
  }

  @AfterEach
  fun cleanUp()
  {
    gc()
  }
}
