package fr.amoya.ktaglib.utils

import fr.amoya.ktaglib.utils.ByteHelper.byteArrayToLong
import fr.amoya.ktaglib.utils.ByteHelper.longToByteArray
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


internal class ByteHelperTest
{

  @ParameterizedTest(name = "Should encode {0}")
  @DisplayName("ShouldEncodeToByteArray")
  @CsvFileSource(resources = ["/longByteArray.csv"], numLinesToSkip = 1)
  fun shouldEncodeToByteArray(long: Long, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte)
  {
    assertTrue { longToByteArray(long).contentEquals(byteArrayOf(byte1, byte2, byte3, byte4)) }
  }

  @ParameterizedTest(name = "Should find {0}")
  @DisplayName("ShouldDecodeToByteArray")
  @CsvFileSource(resources = ["/longByteArray.csv"], numLinesToSkip = 1)
  fun shouldDecodeToByteArray(long: Long, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte)
  {
    assertEquals(long, byteArrayToLong(byteArrayOf(byte4, byte3, byte2, byte1)))
  }

}
