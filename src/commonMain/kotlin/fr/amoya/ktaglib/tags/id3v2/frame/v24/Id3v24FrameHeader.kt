package fr.amoya.ktaglib.tags.id3v2.frame.v24

import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameHeader


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v24
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v24FrameHeader(
  override var id: String = "",
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
  init
  {
    require(id.length == 4) { "ID3v24 Frame header id must be 4 char long" }
  }
}
