package fr.amoya.ktaglib.platformdependent.stringparser

import fr.amoya.ktaglib.common.utils.StringCharsets


/*
* fr.amoya.ktaglib.platformdependent.stringparser
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


interface StringParser
{
  fun parse(bytes: ByteArray, charset: StringCharsets): String
}
