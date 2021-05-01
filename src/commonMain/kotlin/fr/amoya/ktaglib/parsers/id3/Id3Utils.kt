package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.tags.id3.Id3ExtendedHeader
import fr.amoya.ktaglib.tags.id3.frame.Id3Frame
import fr.amoya.ktaglib.tags.id3.frame.Id3FrameHeader
import fr.amoya.ktaglib.utils.ByteHelper


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


@ExperimentalUnsignedTypes
object Id3Utils
{
  // Constants
  private const val tagAlterPreservationFlag: Long = 0x80
  private const val fileAlterPreservationFlag: Long = 0x40
  private const val readOnlyFlag: Long = 0x20
  private const val compressionFlag: Long = 0x80
  private const val encryptionFlag: Long = 0x40
  private const val groupingIdentityFlag: Long = 0x20

  fun getExtendedHeader(rawExtHeader: ByteArray): Id3ExtendedHeader
  {
    rawExtHeader.size
    return Id3ExtendedHeader()
  }

  fun getTagSize(rawSize: ByteArray): Int
  {
    require(rawSize.size == 4) { "ByteArray containing tag size must be 4 Bytes long" }
    var result: Long = 0
    rawSize.forEachIndexed { index, byte ->
      if (byte.toUByte() and 0x80u > 0u) throw Exception("Not Synch-safe size is not supported")
      result = result or ((byte.toLong() and 0x7f) shl (((rawSize.size - 1) - index) * 7))
    }
    return result.toInt()
  }

  fun getFrames(rawFrames: ByteArray): Collection<Id3Frame>
  {
    val res = mutableListOf<Id3Frame>()
    var frameStart = 0
    while (frameStart + 10 < rawFrames.size)
    {
      println("<<<<< $frameStart / ${rawFrames.size}")
      val contentSize = ByteHelper.aggregateBytes(rawFrames.copyOfRange(frameStart + 4, frameStart + 8), 4, Int::class)
      val frameSize = contentSize + 10
      val nextFrame = frameStart + frameSize
      val rawFrame = rawFrames.copyOfRange(frameStart, nextFrame)
      val firstFlagByte = rawFrame[8].toLong()
      val secondFlagByte = rawFrame[9].toLong()
      val frameHeader = Id3FrameHeader(
        id = rawFrame.decodeToString(0, 4),
        size = contentSize,
        tagAlterPreservation = (firstFlagByte and tagAlterPreservationFlag) > 0,
        fileAlterPreservation = (firstFlagByte and fileAlterPreservationFlag) > 0,
        readOnly = (firstFlagByte and readOnlyFlag) > 0,
        compression = (secondFlagByte and compressionFlag) > 0,
        encryption = (secondFlagByte and encryptionFlag) > 0,
        groupingIdentity = (secondFlagByte and groupingIdentityFlag) > 0,
      )

      res.add(Id3Frame(frameHeader, rawFrame.decodeToString(10, frameSize)))
      frameStart = nextFrame
    }
    return res
  }

}
