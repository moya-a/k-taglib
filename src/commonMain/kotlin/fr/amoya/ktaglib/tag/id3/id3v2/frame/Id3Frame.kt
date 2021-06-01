package fr.amoya.ktaglib.tag.id3.id3v2.frame


/*
* fr.amoya.ktaglib.tags.id3v2.frame.content
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

data class Id3Frame(
  var header: Id3FrameHeader,
  var content: Id3FrameContent
)
{
  val name
    get() = header.id.description

  override fun toString(): String = "Id3Frame(id=${header.id}, content=$content)"
}
