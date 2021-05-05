package fr.amoya.ktaglib.common.utils

import fr.amoya.ktaglib.common.TagSpec


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

@ExperimentalUnsignedTypes
object Utils
{
  fun getTagSpec(rawData: ByteArray): TagSpec =
    when (ByteHelper.aggregateBytes(rawData, 4, Long::class))
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
          isAPE(rawData) -> TagSpec.APE
          isId3v1(rawData) -> TagSpec.ID3V1
          else -> TagSpec.NONE
        }
    }

  private fun isAPE(rawData: ByteArray): Boolean =
    ByteHelper.aggregateBytes(rawData, 8, Long::class) == TagSpec.APE.magicNumber

  /**
   * ID3v1 is a bit different as the tags are at the end of the file, hence the takeLast call
   */
  private fun isId3v1(rawData: ByteArray): Boolean =
    if (rawData.size > 128)
      ByteHelper.aggregateBytes(
        rawData.copyOfRange(rawData.size - 128, rawData.size),
        3,
        Long::class
      ) == TagSpec.ID3V1.magicNumber
    else
      false
}
