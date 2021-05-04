package fr.amoya.ktaglib.tags.id3v2.frame.v23

import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameHeader


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v23
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v23FrameHeader(
  override var id: String = "",
  override var size: Int = 0,
  var tagAlterPreservation: Boolean = false,
  var fileAlterPreservation: Boolean = false,
  var readOnly: Boolean = false,
  var compression: Boolean = false,
  var encryption: Boolean = false,
  var groupingIdentity: Boolean = false
) : Id3FrameHeader
{
  init
  {
    require(id.length == 4) { "ID3v23 Frame header id must be 4 char long" }
  }

  override fun toString(): String = "Id3v23FrameHeader(id=$id, size=$size)"
}
