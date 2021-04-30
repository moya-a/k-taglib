package fr.amoya.ktaglib.parsers.abstracts

import fr.amoya.ktaglib.parsers.TagParser


/*
* fr.amoya.ktaglib.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


abstract class AbstractTagParser(protected val rawData: ByteArray) : TagParser
