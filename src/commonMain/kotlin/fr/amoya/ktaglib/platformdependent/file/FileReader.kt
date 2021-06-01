package fr.amoya.ktaglib.platformdependent.file


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


interface FileReader
{
  val size: Long
  val cursor: Long

  fun load(filename: String)
  fun readNBytes(size: String): ByteArray
  fun readEntireFile(): Sequence<Byte>
  fun close()
}
