package fr.amoya.ktaglib.parsers

import fr.amoya.ktaglib.file.FileReader
import fr.amoya.ktaglib.tags.Tag


/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

interface TagParser
{
  fun <T : FileReader> parse(fileName: String, reader: T): Tag
  fun parse(rawData: ByteArray): Tag
}
