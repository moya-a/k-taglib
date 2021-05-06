package fr.amoya.ktaglib.common.tags.id3.id3v1

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.tags.KnownFrames
import fr.amoya.ktaglib.common.tags.Tag


/*
* fr.amoya.ktaglib.common.tags.id3v1
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


data class Id3v1Tag(
  override var tagVersion: TagSpec = TagSpec.ID3V1,
  override var title: String? = null,
  override var artist: String? = null,
  override var album: String? = null,
  override var year: String? = null,
  override var comment: String? = null,
  override var genre: String? = null
) : Tag
{
  override fun get(framesId: KnownFrames): String?
  {
    throw IllegalArgumentException("Id3v1 does not contain frames, use class properties directly")
  }
}

