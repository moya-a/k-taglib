package fr.amoya.ktaglib.platformdependent.stringparser


/*
* fr.amoya.ktaglib.platformdependent.stringparser
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/


expect object StringParserFactory
{
  fun getStringParser(): StringParser
}
