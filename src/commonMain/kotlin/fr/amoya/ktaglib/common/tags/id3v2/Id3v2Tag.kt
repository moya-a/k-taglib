package fr.amoya.ktaglib.common.tags.id3v2

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.tags.Tag
import fr.amoya.ktaglib.common.tags.id3v2.frame.Id3Frame


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

@ExperimentalUnsignedTypes
data class Id3v2Tag(
  var header: Id3Header = Id3Header(),
  var extendedHeader: Id3ExtendedHeader? = null,
  var frames: Collection<Id3Frame> = mutableListOf()
) : Tag
{


  override var tagVersion =
    when (header.versionMajor)
    {
      2    -> TagSpec.ID3V22
      3    -> TagSpec.ID3V23
      4    -> TagSpec.ID3V24
      else -> throw UnsupportedOperationException("ID3v2 version is not recognized")
    }

  override var album: String = ""

  override var title: String = ""

  override var artist: String = ""
}
