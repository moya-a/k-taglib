package fr.amoya.ktaglib.tag.id3.id3v2.v23

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameHeader
import fr.amoya.ktaglib.tag.id3.id3v2.Id3V2KnownFrame
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
  override var id: Id3V2KnownFrame = Id3V23KnownFrame.NONE,
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
