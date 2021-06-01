package fr.amoya.ktaglib.tag.id3.id3v2.frame.v22

import fr.amoya.ktaglib.tag.id3.id3v2.AbstractId3v2TagParser
import fr.amoya.ktaglib.tag.id3.id3v2.AbstractId3v2TagParser.Constants.headerSize
import fr.amoya.ktaglib.tag.id3.id3v2.Id3ExtendedHeader
import fr.amoya.ktaglib.tag.id3.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.tag.id3.id3v2.frame.Id3FrameContent
import fr.amoya.ktaglib.tag.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.tag.id3.id3v2.frame.v23.Id3v23KnownFrames
import fr.amoya.ktaglib.tag.utils.ByteHelper


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

@ExperimentalUnsignedTypes
class Id3v22TagParser : AbstractId3v2TagParser
{

  override fun parseExtendedHeader(rawData: ByteArray): Id3ExtendedHeader? = null

  override fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  {
    require(rawFrameHeader.size >= headerSize) { "Id3v2 Frame header must be $headerSize bytes" }
    val id = try
    {
      Id3v23KnownFrames.valueOf(rawFrameHeader.decodeToString(0, 3))
    }
    catch (_: Exception)
    {
      Id3v23KnownFrames.NONE
    }
    return Id3v22FrameHeader(
      id = id,
      size = ByteHelper.aggregateBytes(rawFrameHeader.copyOfRange(4, 8), 4, UInt::class).toInt()
    )
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame =
    Id3Frame(header, (header.id as Id3v22KnownFrames).parser(rawFrameContent) as Id3FrameContent)
}

