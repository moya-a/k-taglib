package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.parsers.abstracts.AbstractTagParser
import fr.amoya.ktaglib.tags.Tag
import fr.amoya.ktaglib.tags.id3.Id3Header
import fr.amoya.ktaglib.tags.id3.Id3Tag
import fr.amoya.ktaglib.utils.ByteHelper
import kotlin.experimental.and


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/
abstract class AbstractId3v2TagParser : TagParser, AbstractTagParser()
{
  @ExperimentalUnsignedTypes
  companion object Utils
  {
    const val unsynchronisationFlag: Byte = 0x01
    const val extendedHeaderFlag: Byte = 0x02
    const val experimentalFlag: Byte = 0x04

    fun getTagSize(rawSize: ByteArray): Long
    {
      var result: Long = 0
      rawSize.forEachIndexed { index, byte ->
        if (byte.toUByte() and 0x80u > 0u) throw Exception("Not Synch-safe size is not supported")
        result = result or byte.toLong() shl (((rawSize.size - 1) - index) * 7)
      }
      return result
    }
  }

  @ExperimentalUnsignedTypes
  override fun parse(rawData: ByteArray): Tag
  {
    return Id3Tag(
      header = getHeader(rawData.copyOfRange(0, 9))
    )
  }


  @ExperimentalUnsignedTypes
  private fun getHeader(rawHeader: ByteArray): Id3Header
  {
    val rawUSize = rawHeader.copyOfRange(5, 9).toUByteArray()

    rawUSize.forEach { println(it.toString(16)) }

    println(getTagSize(byteArrayOf(0, 0, 2, 1)))

    return Id3Header()
      .apply {
        fileIdentifier = ByteHelper.aggregateBytes(rawHeader, 3, String::class)
        versionMajor = rawHeader[3].toInt()
        versionMinor = rawHeader[4].toInt()
        flagUnsynchronisation = rawHeader[5] and unsynchronisationFlag > 0
        flagExtendedHeader = rawHeader[5] and extendedHeaderFlag > 0
        flagExperimental = rawHeader[5] and experimentalFlag > 0
        size = getTagSize(rawHeader.copyOfRange(5, 9))
      }
  }
}
