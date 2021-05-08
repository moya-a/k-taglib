package fr.amoya.ktaglib.common.utils


import fr.amoya.ktaglib.platformdependent.file.FileReaderFactory
import org.junit.jupiter.api.AfterEach
import org.junit.jupiter.api.Assumptions
import org.junit.jupiter.api.DisplayName
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
  @DisplayName("Should return right tag specification")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun shouldReturnRightTagSpecification(filename: String, expectedType: String)
  {
    val fPath = Path("src", "commonTest", "resources", "data", filename)

    Assumptions.assumeTrue(fPath.exists() && fPath.isRegularFile() && fPath.isReadable())
    val reader = FileReaderFactory.loadFileReader(fPath.absolutePathString())
    assertEquals(expectedType, "${Utils.getTagSpec(reader.readEntireFile())}")
    reader.close()
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
