package fr.amoya.ktaglib.tag.id3.id3v2

import fr.amoya.ktaglib.tag.KnownFrames
import fr.amoya.ktaglib.tag.Tag
import fr.amoya.ktaglib.tag.TagType
import fr.amoya.ktaglib.tag.id3.id3v1.Id3v1KnownGenre.getGenre
import fr.amoya.ktaglib.tag.id3.id3v2.v22.Id3v22Tag
import fr.amoya.ktaglib.tag.id3.id3v2.v23.Id3v23Tag
import fr.amoya.ktaglib.tag.id3.id3v2.v24.Id3v24Tag


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

@ExperimentalUnsignedTypes
interface Id3v2Tag : Tag
{

  var header: Id3Header
  var extendedHeader: Id3ExtendedHeader?
  var frames: Collection<Id3Frame>

  fun getContentFromFrame(frameId: Id3v2KnownFrames): String? =
    frames.find { it.header.id == frameId }?.content?.getContentAsString()

  fun getGenres(rawGenres: String): String =
    if (rawGenres.startsWith("("))
    {
      val tmpStr = Regex("\\([0-9]+\\)").findAll(rawGenres)
        .fold(StringBuilder())
        { result, match ->
          result
            .append(getGenre(match.value.replace(Regex("[()]"), "").toInt()).genre).append(",")
        }
      tmpStr.substring(0, tmpStr.length - 1)
    }
    else
      rawGenres

  override fun get(framesId: KnownFrames): String?
  {
    require(framesId is Id3v2KnownFrames)
    return getContentFromFrame(framesId)
  }

  companion object
  {
    fun createTag(
      header: Id3Header,
      extendedHeader: Id3ExtendedHeader?,
      frames: Collection<Id3Frame>
    ): Id3v2Tag = when (header.version)
    {
      TagType.ID3V22 -> Id3v22Tag(header, extendedHeader, frames)
      TagType.ID3V23 -> Id3v23Tag(header, extendedHeader, frames)
      TagType.ID3V24 -> Id3v24Tag(header, extendedHeader, frames)
      else           -> throw IllegalArgumentException("I cannot make an ID3v2 out of ${header.version.specification}")
    }

    fun printTag(tag: Id3v2Tag): String
    {
      val builder = StringBuilder()
      builder.appendLine(tag.header)
      tag.extendedHeader?.let { builder.appendLine(it) }
      tag.frames.forEach { builder.append(" - ").append(it).appendLine() }
      return builder.toString()
    }
  }
}
