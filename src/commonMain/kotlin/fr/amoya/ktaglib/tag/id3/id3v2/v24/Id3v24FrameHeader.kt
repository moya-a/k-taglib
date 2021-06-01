package fr.amoya.ktaglib.tag.id3.id3v2.v24

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameHeader
import fr.amoya.ktaglib.tag.id3.id3v2.Id3V2KnownFrame


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v24
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v24FrameHeader(
  override var id: Id3V2KnownFrame = Id3V24KnownFrame.NONE,
  override var size: Int = 0,
  var tagAlterPreservation: Boolean = false,
  var fileAlterPreservation: Boolean = false,
  var readOnly: Boolean = false,
  var compression: Boolean = false,
  var encryption: Boolean = false,
  var groupingIdentity: Boolean = false,
  var unsynchronisation: Boolean = false,
  var dataLengthIndicator: Boolean = false
) : Id3FrameHeader
{
  override fun toString(): String = "Id3v23FrameHeader(id=$id, size=$size)"
}
