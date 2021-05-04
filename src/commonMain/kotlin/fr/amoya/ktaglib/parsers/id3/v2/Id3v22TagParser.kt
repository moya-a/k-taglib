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
class Id3v22TagParser : TagParser, AbstractId3v2TagParser()
{

  override fun parseExtendedHeader(rawData: ByteArray): Id3ExtendedHeader? = null

  override fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  {
    TODO("Not yet implemented")
  }

  override fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame
  {
    TODO("Not yet implemented")
  }
}

