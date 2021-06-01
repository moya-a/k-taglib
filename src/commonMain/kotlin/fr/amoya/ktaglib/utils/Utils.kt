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
  fun getTagSpec(rawData: ByteArray): TagType
  {
    var tagType = TagType.NONE
    if (rawData.size >= 4)
      tagType = when (ByteHelper.aggregateBytes(rawData, 4, Long::class))
      {
        TagType.ID3V24.magicNumber -> TagType.ID3V24
        TagType.ID3V23.magicNumber -> TagType.ID3V23
        TagType.ID3V22.magicNumber -> TagType.ID3V22
        TagType.FLAC.magicNumber   -> TagType.FLAC
        TagType.OGG.magicNumber    -> TagType.OGG
        TagType.RIFF.magicNumber   -> TagType.RIFF
        else                       -> TagType.NONE
      }
    if (TagType.NONE == tagType && rawData.size >= 8)
      tagType = if (isAPE(rawData)) TagType.APE else TagType.NONE

    if (TagType.NONE == tagType && rawData.size >= 128)
      tagType = if (isId3v1(rawData)) TagType.ID3V1 else TagType.NONE

    return tagType
  }

  private fun isAPE(rawData: ByteArray): Boolean = rawData.size > 8 && ByteHelper
    .aggregateBytes(rawData, 8, Long::class) == TagType.APE.magicNumber

  /**
   * ID3v1 is a bit different as the tag is in the last 128b at the end of the file
   */
  private fun isId3v1(rawData: ByteArray): Boolean = rawData.size > 128 && ByteHelper
    .aggregateBytes(rawData.takeLast(128).toByteArray(), 3, Long::class) == TagType.ID3V1.magicNumber
}
