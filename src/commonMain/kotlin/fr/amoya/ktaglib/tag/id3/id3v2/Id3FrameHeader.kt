package fr.amoya.ktaglib.tag.id3.id3v2


/*
* fr.amoya.ktaglib.tags.id3
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


interface Id3FrameHeader
{
  var id: Id3V2KnownFrame
  var size: Int
}

