package fr.amoya.ktaglib.common.tags

import fr.amoya.ktaglib.common.TagSpec
import fr.amoya.ktaglib.common.parsers.TagParser
import fr.amoya.ktaglib.common.utils.Utils
import fr.amoya.ktaglib.common.utils.toByteArray
import fr.amoya.ktaglib.platformdependent.file.FileReaderFactory


/*
* fr.amoya.ktaglib.tags
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/


interface Tag
{
  val tagVersion: TagSpec
  val title: String?
  val artist: String?
  val album: String?
  val year: String?
  val comment: String?
  val genre: String?

  operator fun get(framesId: KnownFrames): String?

  companion object
  {
    @ExperimentalUnsignedTypes
    fun getTag(absoluteFileName: String): Tag
    {
      val fileReader = FileReaderFactory.loadFileReader(absoluteFileName)
      try
      {
        val tag = fileReader.readBytes().run {
          TagParser.getParser(Utils.getTagSpec(this)).parse(this)
        }
        fileReader.close()
        return tag
      }
      catch (e: Exception)
      {
        fileReader.close()
        throw e
      }
      catch (e: Error)
      {
        fileReader.close()
        throw e
      }
    }

    @ExperimentalUnsignedTypes
    fun getTagOrNull(absoluteFileName: String): Tag?
    {
      var tag: Tag? = null
      val fileReader = FileReaderFactory.loadFileReader(absoluteFileName)
      try
      {
        tag = fileReader.readBytes().run {
          TagParser.getParser(Utils.getTagSpec(this)).parse(this)
        }
      }
      catch (e: Exception)
      {
        println(e)
      }
      catch (e: Error)
      {
        println(e)
      }
      finally
      {
        fileReader.close()
      }
      return tag
    }
  }
}

