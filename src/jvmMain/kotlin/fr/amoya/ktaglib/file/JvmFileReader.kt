package fr.amoya.ktaglib.file

import java.io.File


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class JvmFileReader(filename: String) : AbstractFileReader(filename)
{
  private var file: File? = null

  override fun load()
  {
    file = File(filename)
  }

  override fun existsAsFile(): Boolean = file?.run { exists() && isFile } ?: false


  override fun isReadable(): Boolean = file?.run { isReadable() } ?: false


  override fun readBytes(): ByteArray =
    file?.run {
      if (existsAsFile() && isReadable())
        readBytes()
      else
        throw Exception("Could not read file")
    } ?: throw Exception("File is not loaded")

}
