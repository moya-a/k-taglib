package fr.amoya.ktaglib.tags

import fr.amoya.ktaglib.TagSpec
import fr.amoya.ktaglib.file.FileReaderFactory
import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.utils.Utils


/*
* fr.amoya.ktaglib.tags
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


interface Tag
{
  var tagVersion: TagSpec
  var album: String
  var title: String
  var artist: String

  companion object
  {
    @ExperimentalUnsignedTypes
    fun getTag(absoluteFileName: String): Tag =
      FileReaderFactory.loadFileReader(absoluteFileName).readBytes().run {
        TagParser.getParser(Utils.getTagSpec(this)).parse(this)
      }
  }
}

