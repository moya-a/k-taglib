package fr.amoya.ktaglib.tag.id3.id3v2.contentFrames

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameContent


/*
* fr.amoya.ktaglib.common.tags.id3v2.frame.contentFrames
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


data class Id3v2frameContentPrivate(
  var ownerId: String,
  var privateData: ByteArray
) : Id3FrameContent
{
  override fun getContentAsString(): String = "$ownerId : ${privateData.size} bytes of data"
}
