package fr.amoya.ktaglib.tags.id3v2


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
  var unsynchronisation: Boolean = false,
  var extendedHeader: Boolean = false,
  var experimental: Boolean = false,
  var tagSize: Int = 0
)
