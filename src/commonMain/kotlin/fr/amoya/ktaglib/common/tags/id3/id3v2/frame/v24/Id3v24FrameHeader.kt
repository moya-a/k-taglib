package fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v24

import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3v2KnownFrames


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v24
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v24FrameHeader(
  override var id: Id3v2KnownFrames = Id3v24KnownFrames.NONE,
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
