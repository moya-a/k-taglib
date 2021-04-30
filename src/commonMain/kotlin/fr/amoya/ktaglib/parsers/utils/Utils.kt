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
    when (rawData.take(4).fold(0L) { sum, next -> sum shl (8) or next.toLong() })
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

  private fun isId3v1(rawData: ByteArray): Boolean =
    rawData.takeLast(128).take(3)
      .fold(0L) { sum, next -> sum shl (8) or next.toLong() } == TagSpec.ID3V1.magicNumber

  private fun isAPE(rawData: ByteArray): Boolean =
    rawData.take(8)
      .fold(0L) { sum, next -> sum shl (8) or next.toLong() } == TagSpec.APE.magicNumber
}
