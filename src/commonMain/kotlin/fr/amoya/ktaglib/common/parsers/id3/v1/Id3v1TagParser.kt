package fr.amoya.ktaglib.common.parsers.id3.v1

import fr.amoya.ktaglib.common.parsers.AbstractTagParser
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.tags.Tag
import fr.amoya.ktaglib.common.tags.id3v1.Id3v1KnownGenre
import fr.amoya.ktaglib.common.tags.id3v1.Id3v1Tag


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class Id3v1TagParser : AbstractTagParser(), TagParser
{
  companion object Constants
  {
    const val minTagSize: Int = 128

    const val titleStartByte = 3
    const val titleEndByte = 33

    const val artistStartByte = 33
    const val artistEndByte = 63

    const val albumStartByte = 63
    const val albumEndByte = 93

    const val yearStartByte = 93
    const val yearEndByte = 97

    const val commentStartByte = 97
    const val commentEndByte = 127

    const val genreByte = 127
  }

  override fun parse(rawData: ByteArray): Tag
  {
    require(rawData.size >= minTagSize) { "The file must be at least $minTagSize bytes to contains an id3v1 tag" }
    val rawTag = rawData.copyOfRange(rawData.size - 128, rawData.size)
    require(checkTag(rawTag.copyOfRange(0, 3))) { "Id3v1 does not contain mandatory TAG" }

    return Id3v1Tag(
      title = decode(rawTag.copyOfRange(titleStartByte, titleEndByte)),
      artist = decode(rawTag.copyOfRange(artistStartByte, artistEndByte)),
      album = decode(rawTag.copyOfRange(albumStartByte, albumEndByte)),
      year = rawTag.decodeToString(yearStartByte, yearEndByte),
      comment = decode(rawTag.copyOfRange(commentStartByte, commentEndByte)),
      genre = Id3v1KnownGenre.getGenre(rawTag[genreByte].toInt()).genre
    )
  }

  private fun decode(bytes: ByteArray): String
  {
    val delimiterIndex = bytes.indexOf(0x00)
    return bytes.decodeToString(0, if (delimiterIndex >= 0) delimiterIndex else bytes.size)
  }


  private fun checkTag(bytes: ByteArray): Boolean
  {
    require(bytes.size == 3) { "Id3v1 TAG must be 3 bytes" }
    return bytes.decodeToString() == "TAG"
  }
}
