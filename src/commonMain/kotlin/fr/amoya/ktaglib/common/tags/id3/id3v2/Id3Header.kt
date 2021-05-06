package fr.amoya.ktaglib.common.tags.id3.id3v2

import fr.amoya.ktaglib.common.TagSpec


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
  // Tags (as they are backward-compatible with older versions, they're set to false)
  var unsynchronisation: Boolean = false,
  var extendedHeader: Boolean = false,
  var experimental: Boolean = false,
  var footerPresent: Boolean = false,
  var tagSize: Int = 0
)
{
  val version: TagSpec
    get() = when (versionMajor)
    {
      2    -> TagSpec.ID3V22
      3    -> TagSpec.ID3V23
      4    -> TagSpec.ID3V24
      else -> TagSpec.NONE
    }

  override fun toString(): String =
    "Id3Header(fileIdentifier=$fileIdentifier, versionMajor=$versionMajor, tagSize=$tagSize)"
}
