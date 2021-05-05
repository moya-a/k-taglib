package fr.amoya.ktaglib.platformdependent.stringparser


/*
* fr.amoya.ktaglib.platformdependent.stringparser
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


actual object StringParserFactory
{
  private val parser: NativeStringParser by lazy { NativeStringParser() }

  actual fun getStringParser(): StringParser = parser
}
