package fr.amoya.ktaglib.tags.id3v2


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3ExtendedHeader(
  var size: Long = 0,
  // tags
  var isUpdate: Boolean = false,
  var crcPresent: Boolean = false,
  var paddingSize: Long = 0,
  var crc: Long? = null
)
