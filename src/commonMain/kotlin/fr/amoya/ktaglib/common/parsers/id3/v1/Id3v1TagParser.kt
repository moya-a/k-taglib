package fr.amoya.ktaglib.common.parsers.id3.v1

import fr.amoya.ktaglib.common.parsers.AbstractTagParser
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.tags.Tag
import fr.amoya.ktaglib.common.tags.id3.id3v1.Id3v1KnownGenre
import fr.amoya.ktaglib.common.tags.id3.id3v1.Id3v1Tag


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
    const val titleSize = 30

    const val artistStartByte = 33
    const val artistSize = 30

    const val albumStartByte = 63
    const val albumSize = 30

    const val yearStartByte = 93
    const val yearSize = 4

    const val commentStartByte = 97
    const val commentSize = 30

    const val genreByte = 127
  }

  override fun parse(rawData: Sequence<Byte>): Tag
  {
    val bytes = rawData.toList()
    require(bytes.size >= minTagSize) { "The file must be at least $minTagSize bytes to contains an id3v1 tag" }
    val rawTag = bytes.takeLast(128)

    require(checkTag(rawTag.take(3).toByteArray())) { "Id3v1 does not contain mandatory TAG" }

    return Id3v1Tag(
      title = decode(rawTag.drop(titleStartByte).take(titleSize).toByteArray()),
      artist = decode(rawTag.drop(artistStartByte).take(artistSize).toByteArray()),
      album = decode(rawTag.drop(albumStartByte).take(albumSize).toByteArray()),
      year = rawTag.drop(yearStartByte).take(yearSize).toByteArray().decodeToString(),
      comment = decode(rawTag.drop(commentStartByte).take(commentSize).toByteArray()),
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
