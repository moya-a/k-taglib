package fr.amoya.ktaglib.tag

import fr.amoya.ktaglib.platformdependent.file.FileReaderFactory
import fr.amoya.ktaglib.utils.Utils


/*
* fr.amoya.ktaglib.tags
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 01/05/2021
*/

interface Tag
{
  val tagVersion: TagType
  val title: String?
  val artist: String?
  val album: String?
  val year: String?
  val comment: String?
  val genre: String?

  val frames: Collection<Frame>

  operator fun get(frameId: KnownFrame): String? =
    frames.find { frameId == it.id }?.content?.getContentAsString()

  companion object
  {
    fun getTag(absoluteFileName: String): Tag
    {
      val fileReader = FileReaderFactory.loadFileReader(absoluteFileName)
      try
      {
        val tag = fileReader.readEntireFile().run {
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

    fun getTagOrNull(absoluteFileName: String): Tag?
    {
      var tag: Tag? = null
      val fileReader = FileReaderFactory.loadFileReader(absoluteFileName)
      try
      {
        tag = fileReader.readEntireFile().run {
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

