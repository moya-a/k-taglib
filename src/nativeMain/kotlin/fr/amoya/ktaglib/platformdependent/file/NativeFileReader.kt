package fr.amoya.ktaglib.platformdependent.file


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class NativeFileReader : FileReader
{
  override val size: Long
    get() = -1L

  override val cursor: Long
    get() = 0L


  override fun load(filename: String)
  {
    TODO("Not yet implemented")
  }

  override fun readNBytes(size: String): ByteArray
  {
    TODO("Not yet implemented")
  }

  override fun readEntireFile(): Sequence<Byte>
  {
    TODO("Not yet implemented")
  }

  override fun close()
  {
    TODO("Not yet implemented")
  }
}
