package fr.amoya.ktaglib.common.parsers

import fr.amoya.ktaglib.common.tags.Tag


/*
* fr.amoya.ktaglib.common.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 06/05/2021
*/


abstract class AbstractTagParser : TagParser
{
  override fun tryParse(rawData: ByteArray): Tag? =
    try
    {
      parse(rawData)
    }
    catch (e: Exception)
    {
      println(e)
      null
    }
}
