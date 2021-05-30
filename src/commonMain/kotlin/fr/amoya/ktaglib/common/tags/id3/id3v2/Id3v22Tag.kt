package fr.amoya.ktaglib.common.tags.id3.id3v2

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.tags.KnownFrames
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3Frame
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v22.Id3v22KnownFrames


/*
* fr.amoya.ktaglib.common.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/

@ExperimentalUnsignedTypes
data class Id3v22Tag(
  override var header: Id3Header = Id3Header(),
  override var extendedHeader: Id3ExtendedHeader? = null,
  override var frames: Collection<Id3Frame> = mutableListOf()
) : Id3v2Tag
{

  override fun get(framesId: KnownFrames): String?
  {
    require(framesId is Id3v22KnownFrames)
    return super.get(framesId)
  }

  override val tagVersion: TagSpec = TagSpec.ID3V22

  override val title: String?
    get() = this[Id3v22KnownFrames.TT2] ?: this[Id3v22KnownFrames.TT1]

  override val artist: String?
    get() = this[Id3v22KnownFrames.TP2] ?: this[Id3v22KnownFrames.TP2]

  override val album: String?
    get() = this[Id3v22KnownFrames.TAL]

  override val year: String?
    get() = this[Id3v22KnownFrames.TYE]

  override val comment: String? = null

  override val genre: String?
    get() = this[Id3v22KnownFrames.TCO]?.run { getGenres(this) }
}
