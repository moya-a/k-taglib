package fr.amoya.ktaglib.tag.id3.id3v2.v23

import fr.amoya.ktaglib.tag.KnownFrame
import fr.amoya.ktaglib.tag.TagType
import fr.amoya.ktaglib.tag.id3.id3v2.Id3v2Tag


/*
* fr.amoya.ktaglib.common.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


class Id3v23Tag : Id3v2Tag()
{
  override val tagVersion: TagType = TagType.ID3V23

  override fun get(frameId: KnownFrame): String?
  {
    require(frameId is Id3V23KnownFrame)
    return super.get(frameId)
  }

  override val title: String?
    get() = this[Id3V23KnownFrame.TIT2] ?: this[Id3V23KnownFrame.TIT1]

  override val artist: String?
    get() = this[Id3V23KnownFrame.TPE2] ?: this[Id3V23KnownFrame.TPE1]

  override val album: String?
    get() = this[Id3V23KnownFrame.TALB]

  override val year: String?
    get() = this[Id3V23KnownFrame.TYER]

  override val comment: String? = null

  override val genre: String?
    get() = this[Id3V23KnownFrame.TCON]?.run { getGenres(this) }
}
