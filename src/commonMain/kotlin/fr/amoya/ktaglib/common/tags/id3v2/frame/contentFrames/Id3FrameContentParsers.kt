package fr.amoya.ktaglib.common.tags.id3v2.frame.contentFrames

import fr.amoya.ktaglib.common.tags.id3v2.frame.Id3FrameContent


/*
* fr.amoya.ktaglib.common.tags.id3v2.frame.contentFrames
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


object Id3FrameContentParsers
{
  private fun getLastDelimiter(delimiter: Int, data: ByteArray): Int = data.indexOfLast { it.toInt() == delimiter }
  private fun getFirstDelimiter(delimiter: Int, data: ByteArray): Int = data.indexOfFirst { it.toInt() == delimiter }

  fun rawParser(data: ByteArray): Id3FrameContent = Id3FrameContentRaw(data)
  fun textParser(data: ByteArray): Id3FrameContent = Id3FrameContentText(data.decodeToString(1, data.size))
  fun userTextParser(data: ByteArray): Id3FrameContent
  {
    val delimiterIndex = getLastDelimiter(0x00, data)
    return Id3FrameContentUserText(
      name = data.decodeToString(1, delimiterIndex),
      value = data.decodeToString(startIndex = delimiterIndex + 1)
    )
  }

  fun commentParser(data: ByteArray): Id3FrameContent
  {
    val delimiterIndex = getLastDelimiter(0x00, data)
    return Id3FrameContentComment(
      language = data.decodeToString(1, 4),
      contentDescriptor = data.decodeToString(4, delimiterIndex),
      comment = data.decodeToString(startIndex = delimiterIndex + 1)
    )
  }

  fun privateParser(data: ByteArray): Id3FrameContent
  {
    val delimiterIndex = getFirstDelimiter(0x00, data)
    return Id3frameContentPrivate(
      ownerId = data.decodeToString(0, delimiterIndex),
      privateData = data.copyOfRange(delimiterIndex + 1, data.size)
    )
  }
}
