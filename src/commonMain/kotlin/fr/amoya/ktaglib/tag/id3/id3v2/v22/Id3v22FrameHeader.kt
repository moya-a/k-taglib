package fr.amoya.ktaglib.tag.id3.id3v2.v22

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameHeader
import fr.amoya.ktaglib.tag.id3.id3v2.Id3V2KnownFrame
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.Transient


/*
* fr.amoya.ktaglib.tags.id3v2.frame.v22
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

@Serializable
@SerialName("Id3v22FrameHeader")
data class Id3v22FrameHeader(
  override var id: Id3V2KnownFrame = Id3V22KnownFrame.NONE,
  @Transient
  override var size: Int = 0
) : Id3FrameHeader
