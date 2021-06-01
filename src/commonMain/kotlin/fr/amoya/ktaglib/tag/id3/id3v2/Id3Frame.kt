package fr.amoya.ktaglib.tag.id3.id3v2

import fr.amoya.ktaglib.tag.Frame


/*
* fr.amoya.ktaglib.tags.id3v2.frame.content
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

class Id3Frame(
  header: Id3FrameHeader,
  override var content: Id3FrameContent
) : Frame
{
  override val id = header.id
}
