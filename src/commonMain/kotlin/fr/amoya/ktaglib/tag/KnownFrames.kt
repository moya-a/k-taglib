package fr.amoya.ktaglib.tag


/*
* fr.amoya.ktaglib.common.tags
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/

typealias frameContentParserFn = (ByteArray) -> FrameContent

interface KnownFrames
{
  val description: String
  val parser: frameContentParserFn
}
