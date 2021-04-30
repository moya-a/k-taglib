package fr.amoya.ktaglib.parsers.utils

import fr.amoya.ktaglib.TagSpec


/*
* fr.amoya.ktaglib.parsers.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


object Utils
{
  fun getTagSpec(rawData: ByteArray): TagSpec =
    when (buildHexTag(rawData))
    {
      TagSpec.ID3V24.magicNumber -> TagSpec.ID3V24
      TagSpec.ID3V23.magicNumber -> TagSpec.ID3V23
      TagSpec.ID3V22.magicNumber -> TagSpec.ID3V22
      TagSpec.FLAC.magicNumber   -> TagSpec.FLAC
      TagSpec.OGG.magicNumber    -> TagSpec.OGG
      TagSpec.RIFF.magicNumber   -> TagSpec.RIFF
      else                       ->
        when
        {
          isAPE(rawData)   -> TagSpec.APE
          isId3v1(rawData) -> TagSpec.ID3V1
          else             -> TagSpec.NONE
        }
    }

  private fun isAPE(rawData: ByteArray): Boolean = buildHexTag(rawData, 8) == TagSpec.APE.magicNumber

  /**
   * ID3v1 is a bit different as the tags are at the end of the file, hence the takeLast call
   */
  private fun isId3v1(rawData: ByteArray): Boolean =
    buildHexTag(rawData.takeLast(128), 3) == TagSpec.ID3V1.magicNumber

  /**
   * Get a number of bytes from the byte array and aggregates it into one Long
   * the goal is to rebuild the Magic Number Hex representation
   */
  private fun buildHexTag(rawData: ByteArray, numberOfBytes: Int = 4): Long =
    rawData.take(numberOfBytes).fold(0L) { aggregate, nextByte -> aggregate shl (8) or nextByte.toLong() }

  private fun buildHexTag(rawData: Collection<Byte>, numberOfBytes: Int): Long =
    rawData.take(numberOfBytes).fold(0L) { aggregate, nextByte -> aggregate shl (8) or nextByte.toLong() }
}
