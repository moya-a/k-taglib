package fr.amoya.ktaglib.tag.id3.id3v2.v22

import fr.amoya.ktaglib.tag.id3.id3v2.*
import fr.amoya.ktaglib.tag.id3.id3v2.AbstractId3v2TagParser.Constants.headerSize
import fr.amoya.ktaglib.tag.id3.id3v2.v23.Id3V23KnownFrame
import fr.amoya.ktaglib.utils.ByteHelper


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
      Id3V23KnownFrame.valueOf(rawFrameHeader.decodeToString(0, 3))
    }
    catch (_: Exception)
    {
      Id3V23KnownFrame.NONE
    }
    return Id3v22FrameHeader(
      id = id,
      size = ByteHelper.aggregateBytes(rawFrameHeader.copyOfRange(4, 8), 4, UInt::class).toInt()
    )
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame =
    Id3Frame(header, (header.id as Id3V22KnownFrame).parserFn(rawFrameContent) as Id3FrameContent)
}

