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

  @Deprecated(
    message = "This function is not optimized as it reads the whole file at once",
    replaceWith = ReplaceWith("readNBytes"),
    DeprecationLevel.WARNING
  )
  fun readEntireFile(): Sequence<Byte>
  fun close()
}
