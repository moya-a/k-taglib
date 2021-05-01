package fr.amoya.ktaglib.tags.id3.frame


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3FrameHeader(
  var id: String = "",
  var size: Int = 0,
  var tagAlterPreservation: Boolean = false,
  var fileAlterPreservation: Boolean = false,
  var readOnly: Boolean = false,
  var compression: Boolean = false,
  var encryption: Boolean = false,
  var groupingIdentity: Boolean = false
)
