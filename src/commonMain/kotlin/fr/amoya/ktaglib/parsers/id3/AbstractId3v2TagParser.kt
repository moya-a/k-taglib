package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.parsers.abstracts.AbstractTagParser
import fr.amoya.ktaglib.parsers.id3.Id3Utils.getExtendedHeader
import fr.amoya.ktaglib.parsers.id3.Id3Utils.getFrames
import fr.amoya.ktaglib.parsers.id3.Id3Utils.getTagSize
import fr.amoya.ktaglib.tags.Tag
import fr.amoya.ktaglib.tags.id3.Id3ExtendedHeader
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
  }

  @ExperimentalUnsignedTypes
  override fun parse(rawData: ByteArray): Tag
  {
    var startOffset = 10
    val header = getHeader(rawData.copyOfRange(0, 10))
    var extHeader: Id3ExtendedHeader? = null
    if (header.extendedHeader)
    {
      startOffset += 10
      extHeader = getExtendedHeader(rawData)
    }
    return Id3Tag(
      header = header,
      extendedHeader = extHeader,
      frames = getFrames(rawData.copyOfRange(startOffset, startOffset + header.tagSize))
    )
  }

  @ExperimentalUnsignedTypes
  private fun getHeader(rawHeader: ByteArray): Id3Header
  {
    return Id3Header()
      .apply {
        fileIdentifier = ByteHelper.aggregateBytes(rawHeader, 3, String::class)
        versionMajor = rawHeader[3].toInt()
        versionMinor = rawHeader[4].toInt()
        unsynchronisation = rawHeader[5] and unsynchronisationFlag > 0
        extendedHeader = rawHeader[5] and extendedHeaderFlag > 0
        experimental = rawHeader[5] and experimentalFlag > 0
        tagSize = getTagSize(rawHeader.copyOfRange(6, 10))
      }
  }
}
