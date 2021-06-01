package fr.amoya.ktaglib.tag.id3.id3v2.contentFrames

import fr.amoya.ktaglib.tag.id3.id3v2.Id3FrameContent


/*
* fr.amoya.ktaglib.common.tags.id3v2.frame.contentFrames
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


data class Id3FrameContentComment(
  var language: String,
  var contentDescriptor: String,
  var comment: String
) : Id3FrameContent
{
  override fun getContentAsString(): String = "[$language] $contentDescriptor : $comment"

}
