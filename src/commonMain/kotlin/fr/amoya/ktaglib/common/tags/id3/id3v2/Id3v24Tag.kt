package fr.amoya.ktaglib.common.tags.id3.id3v2

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.tags.KnownFrames
import fr.amoya.ktaglib.common.tags.Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v24.Id3v24KnownFrames


/*
* fr.amoya.ktaglib.common.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/

@ExperimentalUnsignedTypes
class Id3v24Tag(
  override var header: Id3Header = Id3Header(),
  override var extendedHeader: Id3ExtendedHeader? = null,
  override var frames: Collection<Id3Frame> = mutableListOf()
) : Id3v2Tag(), Tag
{
  override val tagVersion: TagSpec = TagSpec.ID3V24

  override fun get(framesId: KnownFrames): String?
  {
    require(framesId is Id3v24KnownFrames)
    return super.get(framesId)
  }

  override val title: String?
    get() = this[Id3v24KnownFrames.TIT2] ?: this[Id3v24KnownFrames.TIT1]

  override val artist: String?
    get() = this[Id3v24KnownFrames.TPE2] ?: this[Id3v24KnownFrames.TPE1]

  override val album: String?
    get() = this[Id3v24KnownFrames.TALB]

  override val year: String?
    get() = this[Id3v24KnownFrames.TDRL] ?: this[Id3v24KnownFrames.TDRC]

  override val comment: String? = null

  override val genre: String?
    get() = this[Id3v24KnownFrames.TCON]?.run { getGenres(this) }
}
