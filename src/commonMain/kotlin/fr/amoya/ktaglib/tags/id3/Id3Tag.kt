package fr.amoya.ktaglib.tags.id3

import fr.amoya.ktaglib.tags.Tag
import fr.amoya.ktaglib.tags.id3.frame.Id3Frame


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


data class Id3Tag(
  var header: Id3Header,
  var extendedHeader: Id3ExtendedHeader? = null,
  var frames: MutableMap<String, Id3Frame> = mutableMapOf()
) : Tag
