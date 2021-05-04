package fr.amoya.ktaglib.parsers.id3.v2

import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.tags.id3v2.Id3ExtendedHeader
import fr.amoya.ktaglib.tags.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameContent
import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.tags.id3v2.frame.contentFrames.Id3FrameContentRaw
import fr.amoya.ktaglib.tags.id3v2.frame.contentFrames.Id3FrameContentText
import fr.amoya.ktaglib.tags.id3v2.frame.v23.Id3v23FrameHeader
import fr.amoya.ktaglib.utils.ByteHelper


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/
@ExperimentalUnsignedTypes
class Id3v23TagParser : TagParser, AbstractId3v2TagParser()
{
  companion object Utils
  {
    const val frameTagAlterPreservationFlag: Long = 0x80
    const val frameFileAlterPreservationFlag: Long = 0x40
    const val frameReadOnlyFlag: Long = 0x20

    const val frameCompressionFlag: Long = 0x80
    const val frameEncryptionFlag: Long = 0x40
    const val frameGroupingIdentityFlag: Long = 0x20
  }

  override fun parseExtendedHeader(rawData: ByteArray): Id3ExtendedHeader?
  {
    TODO("Not yet implemented")
  }

  override fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  {
    require(rawFrameHeader.size >= headerSize) { "Id3v2 Frame header must be 10 bytes" }
    val firstFlagByte = rawFrameHeader[8].toLong()
    val secondFlagByte = rawFrameHeader[9].toLong()
    return Id3v23FrameHeader(
      id = rawFrameHeader.decodeToString(0, 4),
      size = ByteHelper.aggregateBytes(rawFrameHeader.copyOfRange(4, 8), 4, UInt::class).toInt(),
      tagAlterPreservation = (firstFlagByte and frameTagAlterPreservationFlag) > 0,
      fileAlterPreservation = (firstFlagByte and frameFileAlterPreservationFlag) > 0,
      readOnly = (firstFlagByte and frameReadOnlyFlag) > 0,
      compression = (secondFlagByte and frameCompressionFlag) > 0,
      encryption = (secondFlagByte and frameEncryptionFlag) > 0,
      groupingIdentity = (secondFlagByte and frameGroupingIdentityFlag) > 0,
    )
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame
  {
    val content: Id3FrameContent = if (header.id.startsWith("T"))
    {
      Id3FrameContentText(
        when
        {
          else -> rawFrameContent.decodeToString(1, rawFrameContent.size)
        }
      )
    }
    else
    {
      Id3FrameContentRaw(rawFrameContent)
    }
    return Id3Frame(header, content)
  }
}
