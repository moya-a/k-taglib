package fr.amoya.ktaglib.tags.id3v2.frame


/*
* fr.amoya.ktaglib.tags.id3.frame
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3Frame(
  val header: Id3FrameHeader,
  var body: String
)
