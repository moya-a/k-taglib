package fr.amoya.ktaglib.utils


import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import java.lang.System.gc
import kotlin.io.path.*
import kotlin.test.assertEquals


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

@ExperimentalPathApi
@ExperimentalUnsignedTypes
internal class UtilsTest
{
  @ParameterizedTest(name = "{1} -> {0}")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun `should return right tag specification`(filename: String, expectedType: String)
  {
    val fPath = Path("src", "commonTest", "resources", filename)

    Assumptions.assumeTrue(fPath.exists() && fPath.isRegularFile() && fPath.isReadable())
    assertEquals(expectedType, "${Utils.getTagSpec(fPath.toFile().readBytes())}")
  }

  @AfterEach
  fun cleanUp()
  {
    /**
     * especially important if opening large wav files to avoid outOfMemoryErrors
     */
    gc()
  }
}
