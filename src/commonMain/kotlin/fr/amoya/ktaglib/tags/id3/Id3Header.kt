package fr.amoya.ktaglib.tags.id3


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3Header(
  var fileIdentifier: String = "ID3",
  var versionMajor: Int = 0,
  var versionMinor: Int = 0,
  var flagUnsynchronisation: Boolean = false,
  var flagExtendedHeader: Boolean = false,
  var flagExperimental: Boolean = false,
  var size: Long = 0
)
