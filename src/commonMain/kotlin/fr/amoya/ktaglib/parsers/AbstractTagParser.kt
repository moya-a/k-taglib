package fr.amoya.ktaglib.parsers

import fr.amoya.ktaglib.file.FileReader
import fr.amoya.ktaglib.tags.Tag


/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


abstract class AbstractTagParser : TagParser
{
  override fun <T : FileReader> parse(fileName: String, reader: T): Tag =
    parse(reader.apply { load(fileName) }.readBytes())
}
