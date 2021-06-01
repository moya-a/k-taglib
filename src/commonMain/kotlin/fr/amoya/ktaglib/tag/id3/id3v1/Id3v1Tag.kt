package fr.amoya.ktaglib.tag.id3.id3v1

import fr.amoya.ktaglib.tag.KnownFrame
import fr.amoya.ktaglib.tag.Tag
import fr.amoya.ktaglib.tag.TagType
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


/*
* fr.amoya.ktaglib.common.tags.id3v1
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


@Serializable
@SerialName("ID3V1")
data class Id3v1Tag(
  override var tagVersion: TagType = TagType.ID3V1,
  override var title: String? = null,
  override var artist: String? = null,
  override var album: String? = null,
  override var year: String? = null,
  override var comment: String? = null,
  override var genre: String? = null
) : Tag
{
  @Deprecated(
    message = "Id3v1 does not contain frames, use class properties directly instead",
    level = DeprecationLevel.ERROR
  )
  override fun get(frameId: KnownFrame): String?
  {
    throw IllegalArgumentException("Id3v1 does not contain frames, use class properties directly instead")
  }
}

