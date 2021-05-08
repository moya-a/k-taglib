package fr.amoya.ktaglib.platformdependent.file

import java.io.File
import java.nio.file.Files
import java.nio.file.Paths


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class JvmFileReader : FileReader
{
  private var f: File? = null

  private val _size: Long by lazy { f?.run { Files.size(toPath()) } ?: -1L }
  override val size: Long
    get() = _size
  override val cursor: Long
    get() = 0L

  override fun load(filename: String)
  {
    val file = Paths.get(filename).toFile()
    if (file.exists() && file.isFile && file.canRead())
      f = file
    else
      throw IllegalArgumentException("There were a problem with your file, it either does not exist or is not readable")
  }

  override fun readNBytes(size: String): ByteArray
  {
    TODO("Not yet implemented")
  }

  override fun readEntireFile(): Sequence<Byte>
  {
    var seq: Sequence<Byte> = emptySequence()
    f?.let {
      try
      {
        seq = it.inputStream().buffered().readAllBytes().asSequence()
      }
      finally
      {
        close()
      }
    } ?: throw IllegalStateException("File is not loaded")
    return seq
  }

  override fun close()
  {
    f?.inputStream()?.close()
  }

}
