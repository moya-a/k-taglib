package fr.amoya.ktaglib.tag

import fr.amoya.ktaglib.tag.flac.FlacTagParser
import fr.amoya.ktaglib.tag.id3.id3v1.Id3v1TagParser
import fr.amoya.ktaglib.tag.id3.id3v2.v22.Id3v22TagParser
import fr.amoya.ktaglib.tag.id3.id3v2.v23.Id3v23TagParser
import fr.amoya.ktaglib.tag.id3.id3v2.v24.Id3v24TagParser
import fr.amoya.ktaglib.tag.riff.RiffTagParser
import fr.amoya.ktaglib.tag.xing.XingTagParser

/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

interface TagParser
{
  fun parse(rawData: ByteArray): Tag
  fun tryParse(rawData: ByteArray): Tag? =
    try
    {
      parse(rawData)
    }
    catch (e: Exception)
    {
      println(e)
      null
    }

  companion object
  {
    private val id3v1TagParser: Id3v1TagParser by lazy { Id3v1TagParser() }
    private val id3v22TagParser: Id3v22TagParser by lazy { Id3v22TagParser() }
    private val id3v23TagParser: Id3v23TagParser by lazy { Id3v23TagParser() }
    private val id3v24TagParser: Id3v24TagParser by lazy { Id3v24TagParser() }
    private val flacTagParser: FlacTagParser by lazy { FlacTagParser() }
    private val riffTagParser: RiffTagParser by lazy { RiffTagParser() }
    private val xingTagParser: XingTagParser by lazy { XingTagParser() }


    fun getParser(type: TagType): TagParser =
      when (type)
      {
        TagType.ID3V1  -> id3v1TagParser
        TagType.ID3V22 -> id3v22TagParser
        TagType.ID3V23 -> id3v23TagParser
        TagType.ID3V24 -> id3v24TagParser
        TagType.FLAC   -> flacTagParser
        TagType.RIFF   -> riffTagParser
        TagType.XING   -> xingTagParser
        TagType.OGG    -> throw NotImplementedError("No parser found for type : $type")
        TagType.APE    -> throw NotImplementedError("No parser found for type : $type")
        else           -> throw IllegalArgumentException("This file cannot be parsed as its type is not supported.")
      }
  }
}
