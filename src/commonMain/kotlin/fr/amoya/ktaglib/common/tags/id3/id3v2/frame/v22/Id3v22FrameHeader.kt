package fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v22

import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3v2KnownFrames
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
  override var id: Id3v2KnownFrames = Id3v22KnownFrames.NONE,
  @Transient
  override var size: Int = 0
) : Id3FrameHeader
