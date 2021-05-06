package fr.amoya.ktaglib.common.parsers.flac

import fr.amoya.ktaglib.common.parsers.AbstractTagParser
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.tags.Tag


/*
* fr.amoya.ktaglib.common.parsers.flac
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 06/05/2021
*/


class FlacTagParser : AbstractTagParser(), TagParser
{
  override fun parse(rawData: Sequence<Byte>): Tag
  {
    TODO("Not yet implemented")
  }
}
