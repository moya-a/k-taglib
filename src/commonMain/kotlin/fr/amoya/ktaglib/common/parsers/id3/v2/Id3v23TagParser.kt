package fr.amoya.ktaglib.common.parsers.id3.v2

import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23.Id3v23FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23.Id3v23KnownFrames
import fr.amoya.ktaglib.common.utils.ByteHelper


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

  override fun parseExtendedHeader(rawData: ByteArray): fr.amoya.ktaglib.common.tags.id3.id3v2.Id3ExtendedHeader?
  {
    TODO("Not yet implemented")
  }

  override fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  {
    require(rawFrameHeader.size >= headerSize) { "Id3v2 Frame header must be $headerSize bytes" }
    val firstFlagByte = rawFrameHeader[8].toLong()
    val secondFlagByte = rawFrameHeader[9].toLong()
    val id = try
    {
      Id3v23KnownFrames.valueOf(rawFrameHeader.decodeToString(0, 4))
    }
    catch (_: Exception)
    {
      Id3v23KnownFrames.NONE
    }
    return Id3v23FrameHeader(
      id = id,
      size = ByteHelper.aggregateBytes(rawFrameHeader.copyOfRange(4, 8), 4, UInt::class).toInt(),

      tagAlterPreservation = (firstFlagByte and frameTagAlterPreservationFlag) > 0,
      fileAlterPreservation = (firstFlagByte and frameFileAlterPreservationFlag) > 0,
      readOnly = (firstFlagByte and frameReadOnlyFlag) > 0,

      compression = (secondFlagByte and frameCompressionFlag) > 0,
      encryption = (secondFlagByte and frameEncryptionFlag) > 0,
      groupingIdentity = (secondFlagByte and frameGroupingIdentityFlag) > 0,
    )
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame =
    Id3Frame(header, (header.id as Id3v23KnownFrames).parser(rawFrameContent))
}
