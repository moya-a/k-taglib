package fr.amoya.ktaglib.tag.id3.id3v2.contentFrames

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameContent


/*
* fr.amoya.ktaglib.common.tags.id3v2.frame.contentFrames
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


object Id3v2FrameContentParsers
{
  private const val requiredMessageNotEmpty = "Some data is required in order to parse the frame"
  private const val requiredMessageDelimiterIndex = "Delimiter index is lesser than required"

  private fun getLastDelimiter(delimiter: Int, data: ByteArray): Int = data.indexOfLast { it.toInt() == delimiter }
  private fun getFirstDelimiter(delimiter: Int, data: ByteArray): Int = data.indexOfFirst { it.toInt() == delimiter }

  fun rawParser(data: ByteArray): Id3FrameContent = Id3v2FrameContentRaw(data)
  fun textParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    return if (data.last().toInt() == 0 && data.size > 1)
      Id3v2FrameContentText(data.decodeToString(1, data.size - 1))
    else
      Id3v2FrameContentText(data.decodeToString(1, data.size))
  }

  fun urlParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    val cleanData = if (data.last().toInt() == 0) data.copyOfRange(0, data.size - 1) else data
    val delimiterIndex = getLastDelimiter(0x00, cleanData)
    return Id3v2FrameContentURL(
      url = cleanData.decodeToString(0, if (delimiterIndex > 0) delimiterIndex else cleanData.size),
    )
  }

  fun userUrlParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    val cleanData = if (data.last().toInt() == 0) data.copyOfRange(0, data.size - 1) else data
    val delimiterIndex = getLastDelimiter(0x00, cleanData)
    return Id3v2FrameContentUserURL(
      description = cleanData.decodeToString(0, delimiterIndex),
      url = cleanData.decodeToString(delimiterIndex + 1)
    )
  }

  fun userTextParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    val cleanData = if (data.last().toInt() == 0) data.copyOfRange(0, data.size - 1) else data
    val delimiterIndex = getLastDelimiter(0x00, cleanData)
    require(delimiterIndex > 1) { requiredMessageDelimiterIndex }
    return Id3v2FrameContentUserText(
      name = cleanData.decodeToString(1, delimiterIndex),
      value = cleanData.decodeToString(startIndex = delimiterIndex + 1)
    )
  }

  fun commentParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    val delimiterIndex = getLastDelimiter(0x00, data)
    return Id3v2FrameContentComment(
      language = data.decodeToString(1, 4),
      contentDescriptor = data.decodeToString(4, delimiterIndex),
      comment = data.decodeToString(startIndex = delimiterIndex + 1)
    )
  }

  fun privateParser(data: ByteArray): Id3FrameContent
  {
    require(data.isNotEmpty()) { requiredMessageNotEmpty }
    val delimiterIndex = getFirstDelimiter(0x00, data)
    return Id3v2frameContentPrivate(
      ownerId = data.decodeToString(0, delimiterIndex),
      privateData = data.copyOfRange(delimiterIndex + 1, data.size)
    )
  }
}
