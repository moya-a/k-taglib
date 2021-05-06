package fr.amoya.ktaglib.common.parsers

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.parsers.flac.FlacTagParser
import fr.amoya.ktaglib.common.parsers.id3.v1.Id3v1TagParser
import fr.amoya.ktaglib.common.parsers.id3.v2.Id3v22TagParser
import fr.amoya.ktaglib.common.parsers.id3.v2.Id3v23TagParser
import fr.amoya.ktaglib.common.parsers.id3.v2.Id3v24TagParser
import fr.amoya.ktaglib.common.parsers.riff.RiffTagParser
import fr.amoya.ktaglib.common.tags.Tag

/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

interface TagParser
{
  fun parse(rawData: Sequence<Byte>): Tag
  fun tryParse(rawData: Sequence<Byte>): Tag?

  @ExperimentalUnsignedTypes
  companion object
  {
    private val id3v1TagParser: Id3v1TagParser by lazy { Id3v1TagParser() }
    private val id3v22TagParser: Id3v22TagParser by lazy { Id3v22TagParser() }
    private val id3v23TagParser: Id3v23TagParser by lazy { Id3v23TagParser() }
    private val id3v24TagParser: Id3v24TagParser by lazy { Id3v24TagParser() }
    private val flacTagParser: FlacTagParser by lazy { FlacTagParser() }
    private val riffTagParser: RiffTagParser by lazy { RiffTagParser() }


    fun getParser(type: TagSpec): TagParser =
      when (type)
      {
        TagSpec.ID3V1  -> id3v1TagParser
        TagSpec.ID3V22 -> id3v22TagParser
        TagSpec.ID3V23 -> id3v23TagParser
        TagSpec.ID3V24 -> id3v24TagParser
        TagSpec.FLAC   -> flacTagParser
        TagSpec.RIFF   -> riffTagParser
        TagSpec.OGG    -> throw NotImplementedError("No parser found for type : $type")
        TagSpec.APE    -> throw NotImplementedError("No parser found for type : $type")
        else           -> throw IllegalArgumentException("This file cannot be parsed as its type is not supported.")
      }
  }
}
