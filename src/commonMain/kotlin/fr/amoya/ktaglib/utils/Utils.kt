package fr.amoya.ktaglib.utils

import fr.amoya.ktaglib.tag.TagType


/*
* fr.amoya.ktaglib.utils
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

object Utils
{
  fun getTagSpec(rawData: Sequence<Byte>): TagType =
    when (ByteHelper.aggregateBytes(rawData, 4, Long::class))
    {
      TagType.ID3V24.magicNumber -> TagType.ID3V24
      TagType.ID3V23.magicNumber -> TagType.ID3V23
      TagType.ID3V22.magicNumber -> TagType.ID3V22
      TagType.FLAC.magicNumber   -> TagType.FLAC
      TagType.OGG.magicNumber    -> TagType.OGG
      TagType.RIFF.magicNumber   -> TagType.RIFF
      else                       ->
        when
        {
          isAPE(rawData)   -> TagType.APE
          isId3v1(rawData) -> TagType.ID3V1
          else             -> TagType.NONE
        }
    }

  private fun isAPE(rawData: Sequence<Byte>): Boolean =
    ByteHelper.aggregateBytes(rawData, 8, Long::class) == TagType.APE.magicNumber

  /**
   * ID3v1 is a bit different as the tag is in the last 128b at the end of the file
   */
  private fun isId3v1(rawData: Sequence<Byte>): Boolean
  {
    val lst = rawData.toList()
    return lst.size > 128 && ByteHelper
      .aggregateBytes(lst.takeLast(128).asSequence(), 3, Long::class) == TagType.ID3V1.magicNumber
  }
}
