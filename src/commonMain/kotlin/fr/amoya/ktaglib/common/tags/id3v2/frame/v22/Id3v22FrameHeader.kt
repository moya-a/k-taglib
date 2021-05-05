package fr.amoya.ktaglib.common.tags.id3v2.frame.v22

import fr.amoya.ktaglib.common.tags.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3v2.frame.Id3v2KnownFrame


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v22
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3v22FrameHeader(
  override var id: Id3v2KnownFrame = Id3v22KnownFrames.NONE,
  override var size: Int = 0
) : Id3FrameHeader
