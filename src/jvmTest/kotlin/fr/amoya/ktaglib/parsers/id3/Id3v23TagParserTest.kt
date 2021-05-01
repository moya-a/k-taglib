package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.TagSpec
import fr.amoya.ktaglib.utils.ByteHelper.longToByteArray
import fr.amoya.ktaglib.utils.Utils
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
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
internal class Id3v23TagParserTest
{

  @ParameterizedTest(name = "{0}")
  @DisplayName("Parsing should work")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun parsingShouldWork(filename: String)
  {
    val fPath = Path("src", "commonTest", "resources", filename)
    Assumptions.assumeTrue(fPath.exists() && fPath.isRegularFile() && fPath.isReadable())

    val rawData = fPath.toFile().readBytes()
    Assumptions.assumeTrue(Utils.getTagSpec(rawData) == TagSpec.ID3V23)

    val tag = Id3v23TagParser().parse(rawData)
    println(tag)
  }

  @ParameterizedTest(name = "{1} decoded to {0}")
  @DisplayName("Should decode the right tag size")
  @CsvSource(value = ["257,513"])
  fun shouldDecodeTheRightTagSize(size: Long, encodedSize: Long)
  {
    assertEquals(size, AbstractId3v2TagParser.getTagSize(longToByteArray(encodedSize)))
  }


  @AfterEach
  fun cleanUp()
  {
    gc()
  }
}
