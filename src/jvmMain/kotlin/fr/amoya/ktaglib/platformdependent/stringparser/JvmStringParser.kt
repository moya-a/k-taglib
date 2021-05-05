package fr.amoya.ktaglib.platformdependent.stringparser

import fr.amoya.ktaglib.common.utils.StringCharsets


/*
* fr.amoya.ktaglib.platformdependent.stringparser
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


class JvmStringParser : StringParser
{
  override fun parse(bytes: ByteArray, charset: StringCharsets): String =
    when (charset)
    {
      StringCharsets.ISO_8859_1 -> bytes.toString(Charsets.ISO_8859_1)
      else                      -> throw IllegalArgumentException("Charset is not supported")
    }
}
