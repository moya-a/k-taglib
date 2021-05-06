package fr.amoya.ktaglib.platformdependent.file

import java.io.InputStream
import java.nio.file.Paths


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class JvmFileReader : FileReader
{
  private var input: InputStream? = null

  override fun load(filename: String)
  {
    val file = Paths.get(filename).toFile()
    if (file.exists() && file.isFile && file.canRead())
      input = file.inputStream().buffered()
    else
      throw IllegalArgumentException("There were a problem with your file, it either does not exist or is not readable")
  }

  override fun readBytes(): ByteArray =
    input?.run {
      readBytes()
    } ?: throw IllegalStateException("File is not loaded")

  override fun close()
  {
    input?.close()
  }

}
