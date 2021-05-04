package fr.amoya.ktaglib.parsers

import fr.amoya.ktaglib.TagSpec
import fr.amoya.ktaglib.parsers.id3.Id3v22TagParser
import fr.amoya.ktaglib.parsers.id3.Id3v23TagParser
import fr.amoya.ktaglib.parsers.id3.Id3v24TagParser
import fr.amoya.ktaglib.tags.Tag

/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

interface TagParser
{
  fun parse(rawData: ByteArray): Tag

  companion object
  {
    fun getParser(type: TagSpec): TagParser =
      when (type)
      {
        TagSpec.ID3V22 -> Id3v22TagParser()
        TagSpec.ID3V23 -> Id3v23TagParser()
        TagSpec.ID3V24 -> Id3v24TagParser()
        TagSpec.ID3V1  -> throw NotImplementedError("No parser found for type : $type")
        TagSpec.FLAC   -> throw NotImplementedError("No parser found for type : $type")
        TagSpec.RIFF   -> throw NotImplementedError("No parser found for type : $type")
        TagSpec.OGG    -> throw NotImplementedError("No parser found for type : $type")
        TagSpec.APE    -> throw NotImplementedError("No parser found for type : $type")
        else           -> throw IllegalArgumentException("This file cannot be parsed as its type is not supported.")
      }
  }
}
