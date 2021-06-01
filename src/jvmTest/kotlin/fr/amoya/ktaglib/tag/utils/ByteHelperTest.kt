package fr.amoya.ktaglib.tag.utils

import fr.amoya.ktaglib.tag.utils.ByteHelper.byteArrayToLong
import fr.amoya.ktaglib.tag.utils.ByteHelper.intToSynchSafeByteArray
import fr.amoya.ktaglib.tag.utils.ByteHelper.longToByteArray
import fr.amoya.ktaglib.tag.utils.ByteHelper.synchSafeBytesToInt
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import org.junit.jupiter.params.provider.CsvSource
import kotlin.test.assertEquals
import kotlin.test.assertTrue


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

@ExperimentalUnsignedTypes
internal class ByteHelperTest
{

  @ParameterizedTest(name = "Should encode {0} to ByteArray")
  @DisplayName("Should encode Int To ByteArray")
  @CsvFileSource(resources = ["/longByteArray.csv"], numLinesToSkip = 1)
  fun shouldEncodeIntToByteArray(long: Long, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte)
  {
    assertTrue { longToByteArray(long).contentEquals(byteArrayOf(byte1, byte2, byte3, byte4)) }
  }

  @ParameterizedTest(name = "Should decode Byte array to {0}")
  @DisplayName("Should decode ByteArray To Int")
  @CsvFileSource(resources = ["/longByteArray.csv"], numLinesToSkip = 1)
  fun shouldDecodeByteArrayToInt(long: Long, byte1: Byte, byte2: Byte, byte3: Byte, byte4: Byte)
  {
    assertEquals(long, byteArrayToLong(byteArrayOf(byte4, byte3, byte2, byte1)))
  }

  @ParameterizedTest(name = "safe-synch {1} decoded to int {0}")
  @DisplayName("Should decode safe-synch byteArray to int")
  @CsvSource(value = ["257,513"])
  fun shouldDecodeSafeSynchByteArrayToInt(size: Long, encodedSize: Long)
  {
    assertEquals(size, synchSafeBytesToInt(longToByteArray(encodedSize)).toLong())
  }

  @ParameterizedTest(name = "int {0} should encode {1} to safe-synch")
  @DisplayName("Should encode int to safe-synch byteArray")
  @CsvSource(value = ["257,513"])
  fun shouldEncodeIntToSafeSynchByteArray(size: Long, encodedSize: Long)
  {
    assertTrue { longToByteArray(encodedSize).contentEquals(intToSynchSafeByteArray(size.toInt())) }
  }

}
