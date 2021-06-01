package fr.amoya.ktaglib.tag.id3.id3v2

import fr.amoya.ktaglib.tag.Frame
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

abstract class Id3v2Tag : Tag
{
  override val frames: MutableCollection<Frame> = mutableListOf()
  protected var header: Id3Header = Id3Header()
  protected var extendedHeader: Id3ExtendedHeader? = null

  fun getGenres(rawGenres: String): String =
    if (rawGenres.startsWith("("))
    {
      val tmpStr = Regex("\\([0-9]+\\)").findAll(rawGenres)
        .fold(StringBuilder())
        { result, match ->
          result.append(getGenre(match.value.replace(Regex("[()]"), "").toInt()).genre).append(",")
        }
      tmpStr.substring(0, tmpStr.length - 1)
    }
    else
      rawGenres

  companion object Id3v2TagBuilder
  {
    fun buildId3v2Tag(
      header: Id3Header,
      extendedHeader: Id3ExtendedHeader?,
      frames: Collection<Id3Frame>
    ): Id3v2Tag = when (header.version)
    {
      TagType.ID3V22 ->
        Id3v22Tag().apply {
          this.header = header
          this.extendedHeader = extendedHeader
          this.frames.addAll(frames)
        }
      TagType.ID3V23 ->
        Id3v23Tag().apply {
          this.header = header
          this.extendedHeader = extendedHeader
          this.frames.addAll(frames)
        }
      TagType.ID3V24 ->
        Id3v24Tag().apply {
          this.header = header
          this.extendedHeader = extendedHeader
          this.frames.addAll(frames)
        }
      else           ->
        throw IllegalArgumentException("I cannot make an ID3v2 out of ${header.version.specification}")
    }
  }
}
