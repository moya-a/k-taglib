package fr.amoya.ktaglib.common.parsers.id3.v2

import fr.amoya.ktaglib.common.Tag
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.Id3ExtendedHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.Id3v2Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23.Id3v23KnownFrames
import fr.amoya.ktaglib.common.utils.ByteHelper
import fr.amoya.ktaglib.common.utils.toByteArray
import kotlin.experimental.and


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

@ExperimentalUnsignedTypes
interface AbstractId3v2TagParser : TagParser
{

  companion object Constants
  {
    // general
    const val headerSize: Int = 10
    const val extendedHeaderSize: Int = 10
    const val minimalFrameSize: Int = 11

    // tag flags
    const val tagUnsynchronisationFlag: Byte = 0x01
    const val tagExtendedHeaderFlag: Byte = 0x02
    const val tagExperimentalFlag: Byte = 0x04
    const val tagFooterPresentFlag: Byte = 0x08

  }

  fun parseExtendedHeader(rawData: ByteArray): Id3ExtendedHeader?
  fun parseFrameHeader(rawFrameHeader: ByteArray): Id3FrameHeader
  fun parseFrame(header: Id3FrameHeader, rawFrameContent: ByteArray): Id3Frame


  override fun parse(rawData: Sequence<Byte>): Tag
  {
    val tagHeader = parseTagHeader(rawData.toByteArray(headerSize))
    var extendedHeader: Id3ExtendedHeader? = null
    if (tagHeader.extendedHeader)
    {
      extendedHeader = parseExtendedHeader(rawData.drop(headerSize).toByteArray(extendedHeaderSize))
    }
    return Id3v2Tag.createTag(
      header = tagHeader,
      extendedHeader = extendedHeader,
      frames = parseFrames(tagHeader.tagSize, rawData.drop(10))
    )
  }

  private fun parseFrames(tagSize: Int, rawData: Sequence<Byte>): Collection<Id3Frame>
  {
    val frames: MutableList<Id3Frame> = mutableListOf()
    var cursor = 0

    while (cursor + minimalFrameSize < tagSize - 1)
    {
      val frameHeaderStart = cursor
      val frameHeaderEnd = frameHeaderStart + headerSize

      val frameRawHeader = rawData.drop(frameHeaderStart).toByteArray(headerSize)
      val frameHeaderParsed = parseFrameHeader(frameRawHeader)

      if (frameHeaderParsed.id !== Id3v23KnownFrames.NONE)
      {
        val frameRawContent = rawData.drop(frameHeaderEnd).toByteArray(frameHeaderParsed.size)
        frames.add(parseFrame(frameHeaderParsed, frameRawContent))
      }

      val frameContentEnd = frameHeaderEnd + frameHeaderParsed.size
      val nextFrame = frameContentEnd - 1

      // here I check if there might be another frame after a 0x00 is encountered
      // while (nextFrame < rawData.size && rawData[nextFrame].toInt() == 0 && nextFrame < tagSize) ++nextFrame

      cursor = if (nextFrame < frameContentEnd) frameContentEnd else nextFrame
    }
    return frames
  }


  private fun parseTagHeader(rawHeader: ByteArray): fr.amoya.ktaglib.common.tags.id3.id3v2.Id3Header
  {
    require(rawHeader.size >= headerSize) { "Id3 header size must be $headerSize bytes" }
    return fr.amoya.ktaglib.common.tags.id3.id3v2.Id3Header()
      .apply {
        fileIdentifier = rawHeader.decodeToString(0, 3)
        versionMajor = rawHeader[3].toInt()
        versionMinor = rawHeader[4].toInt()
        unsynchronisation = rawHeader[5] and tagUnsynchronisationFlag > 0
        extendedHeader = rawHeader[5] and tagExtendedHeaderFlag > 0
        experimental = rawHeader[5] and tagExperimentalFlag > 0
        footerPresent = rawHeader[5] and tagFooterPresentFlag > 0
        tagSize = ByteHelper.synchSafeBytesToUInt(rawHeader.copyOfRange(6, 10)).toInt()
      }
  }
}
