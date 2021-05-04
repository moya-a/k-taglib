package fr.amoya.ktaglib.tags.id3v2.frame.v22

import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameHeader


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v22
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v22FrameHeader(
  override var id: String = "",
  override var size: Int = 0
) : Id3FrameHeader
{
  init
  {
    require(id.length == 3) { "ID3v22 Frame header id must be 3 char long" }
  }
}
