package fr.amoya.ktaglib.tag.id3.id3v2.v23

import fr.amoya.ktaglib.tag.KnownFrames
import fr.amoya.ktaglib.tag.TagType
import fr.amoya.ktaglib.tag.id3.id3v2.Id3ExtendedHeader
import fr.amoya.ktaglib.tag.id3.id3v2.Id3Frame
import fr.amoya.ktaglib.tag.id3.id3v2.Id3Header
import fr.amoya.ktaglib.tag.id3.id3v2.Id3v2Tag
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


/*
* fr.amoya.ktaglib.common.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


@Serializable
@SerialName("ID3V23")
data class Id3v23Tag(
  @Transient
  override var header: Id3Header = Id3Header(),
  @Transient
  override var extendedHeader: Id3ExtendedHeader? = null,
  @Transient
  override var frames: Collection<Id3Frame> = mutableListOf()
) : Id3v2Tag
{
  override val tagVersion: TagType = TagType.ID3V23

  override fun get(framesId: KnownFrames): String?
  {
    require(framesId is Id3v23KnownFrames)
    return super.get(framesId)
  }

  override val title: String?
    get() = this[Id3v23KnownFrames.TIT2] ?: this[Id3v23KnownFrames.TIT1]

  override val artist: String?
    get() = this[Id3v23KnownFrames.TPE2] ?: this[Id3v23KnownFrames.TPE1]

  override val album: String?
    get() = this[Id3v23KnownFrames.TALB]

  override val year: String?
    get() = this[Id3v23KnownFrames.TYER]

  override val comment: String? = null

  override val genre: String?
    get() = this[Id3v23KnownFrames.TCON]?.run { getGenres(this) }
}
