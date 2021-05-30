package fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23

import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3v2KnownFrames
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v23
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

@Serializable
@SerialName("Id3v23FrameHeader")
data class Id3v23FrameHeader(
  override var id: Id3v2KnownFrames = Id3v23KnownFrames.NONE,
  @Transient
  override var size: Int = 0,
  @Transient
  var tagAlterPreservation: Boolean = false,
  @Transient
  var fileAlterPreservation: Boolean = false,
  @Transient
  var readOnly: Boolean = false,
  @Transient
  var compression: Boolean = false,
  @Transient
  var encryption: Boolean = false,
  @Transient
  var groupingIdentity: Boolean = false
) : Id3FrameHeader
{
  override fun toString(): String = "Id3v23FrameHeader(id=$id, size=$size)"
}
