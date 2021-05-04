package fr.amoya.ktaglib.parsers.id3.v2

import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.tags.id3v2.Id3ExtendedHeader
import fr.amoya.ktaglib.tags.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameHeader


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

@ExperimentalUnsignedTypes
class Id3v24TagParser : TagParser, AbstractId3v2TagParser()
{
  companion object Utils
  {
    const val frameTagAlterPreservationFlag: Long = 0x40
    const val frameFileAlterPreservationFlag: Long = 0x20
    const val frameReadOnlyFlag: Long = 0x10

    const val frameGroupingIdentityFlag: Long = 0x40
    const val frameCompressionFlag: Long = 0x08
    const val frameEncryptionFlag: Long = 0x04
    const val frameUnsynchronisationFlag: Long = 0x02
    const val frameDataLengthIndicatorFlag: Long = 0x01
  }

  override fun parseExtendedHeader(rawData: ByteArray): Id3ExtendedHeader?
  {
    TODO("Not yet implemented")
  }

  override fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  {
    TODO("Not yet implemented")
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame
  {
    TODO("Not yet implemented")
  }
}
