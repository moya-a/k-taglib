package fr.amoya.ktaglib.common.tags

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.utils.Utils
import fr.amoya.ktaglib.platformdependent.file.FileReaderFactory


/*
* fr.amoya.ktaglib.tags
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


interface Tag
{
  val tagVersion: TagSpec
  val title: String?
  val artist: String?
  val album: String?
  val year: String?
  val comment: String?
  val genre: String?

  operator fun get(framesId: KnownFrames): String?

  companion object
  {
    @ExperimentalUnsignedTypes
    fun getTag(absoluteFileName: String): Tag =
      FileReaderFactory.loadFileReader(absoluteFileName).readBytes().run {
        TagParser.getParser(Utils.getTagSpec(this)).parse(this)
      }
  }
}

