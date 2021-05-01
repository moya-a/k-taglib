package fr.amoya.ktaglib.parsers.id3

import fr.amoya.ktaglib.parsers.TagParser
import fr.amoya.ktaglib.parsers.abstracts.AbstractSequentialTagParser
import fr.amoya.ktaglib.tags.id3.Id3Header
import fr.amoya.ktaglib.utils.Aggregator


/*
* fr.amoya.ktaglib.parsers.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


abstract class AbstractId3v2TagParser(rawData: ByteArray) : TagParser, AbstractSequentialTagParser(rawData)
{
  fun getHeader(): Id3Header
  {
    return Id3Header()
      .apply {
        // fileIdentifier = Aggregator.aggregateBytes()
      }
  }
}
