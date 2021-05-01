package fr.amoya.ktaglib.tags.id3


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3ExtendedHeader(
  var size: Long,
  var crcFlag: Boolean,
  var paddingSize: Long,
  var crc: Long? = null
)
