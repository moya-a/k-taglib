package fr.amoya.ktaglib.common.utils

import fr.amoya.ktaglib.common.TagSpec


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

object Utils
{
  fun getTagSpec(rawData: Sequence<Byte>): TagSpec =
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
          isAPE(rawData)   -> TagSpec.APE
          isId3v1(rawData) -> TagSpec.ID3V1
          else             -> TagSpec.NONE
        }
    }

  private fun isAPE(rawData: Sequence<Byte>): Boolean =
    ByteHelper.aggregateBytes(rawData, 8, Long::class) == TagSpec.APE.magicNumber

  /**
   * ID3v1 is a bit different as the tag is in the last 128b at the end of the file
   */
  private fun isId3v1(rawData: Sequence<Byte>): Boolean
  {
    val lst = rawData.toList()
    return lst.size > 128 && ByteHelper
      .aggregateBytes(lst.takeLast(128).asSequence(), 3, Long::class) == TagSpec.ID3V1.magicNumber
  }
}
