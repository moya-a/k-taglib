package fr.amoya.ktaglib.platformdependent.file

import java.io.File
import java.nio.file.Files


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


class JvmFileReader : FileReader
{
  private var file: File? = null

  override fun load(filename: String)
  {
    file = File(filename)
  }

  override fun readBytes(): ByteArray =
    file?.run {
      if (this.exists() && this.isFile && Files.isReadable(this.toPath()))
        readBytes()
      else
        throw IllegalArgumentException("Could not read file")
    } ?: throw IllegalStateException("File is not loaded")

}
