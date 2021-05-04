package fr.amoya.ktaglib.tags.id3v2.frame.contentFrames

import fr.amoya.ktaglib.tags.id3v2.frame.Id3FrameContent


/*
* fr.amoya.ktaglib.tags.id3v2.frame.contentFrames
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/


data class Id3FrameContentText(
  var content: String
) : Id3FrameContent
