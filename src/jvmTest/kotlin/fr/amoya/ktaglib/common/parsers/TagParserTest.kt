package fr.amoya.ktaglib.common.parsers

import fr.amoya.ktaglib.common.tags.Tag
import fr.amoya.ktaglib.common.tags.id3v2.Id3v2Tag
import fr.amoya.ktaglib.common.tags.id3v2.Id3v2Tag.Companion.printTag
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvFileSource
import kotlin.io.path.*
import kotlin.test.assertEquals


/*
* fr.amoya.ktaglib.common.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/

@ExperimentalUnsignedTypes
@ExperimentalPathApi
internal class TagParserTest
{

  /*
  ** Error Checking
  */
  @ParameterizedTest(name = "Should throw an error : {0}")
  @DisplayName("Should throw an error")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun shouldThrowAnError(filename: String, fileType: String)
  {
    val fPath = Path("src", "commonTest", "resources", "data", filename)
    Assumptions.assumingThat(!(fPath.exists() && fPath.isRegularFile() && fPath.isReadable()))
    {
      assertThrows<IllegalArgumentException> { Tag.getTag(fPath.absolutePathString()) }
    }
    Assumptions.assumingThat(
      !fileType.contains("ID3") &&
      (fileType.contains("FLAC") || fileType.contains("RIFF") || fileType.contains("OGG") || fileType.contains("APE"))
    )
    {
      assertThrows<NotImplementedError> { Tag.getTag(fPath.absolutePathString()) }
    }
  }

  /*
  ** Actual Parsing Check
  */
  @ParameterizedTest(name = "Should Parse : {1} - {0}")
  @DisplayName("Should Parse Tag")
  @CsvFileSource(resources = ["/expected_results.csv"], numLinesToSkip = 1)
  fun shouldParseTag(
    filename: String,
    fileType: String,
    no: Int?,
    bitrate: Int?,
    title: String?,
    album: String?,
    artist: String?,
    genre: String?,
    year: Int?,
    duration: Int?
  )
  {
    println("filename = [${filename}], fileType = [${fileType}], no = [${no}], bitrate = [${bitrate}], title = [${title}], album = [${album}], artist = [${artist}], genre = [${genre}], year = [${year}], duration = [${duration}]")
    val fPath = Path("src", "commonTest", "resources", "data", filename)
    Assumptions.assumeTrue(fileType.contains("ID3") && fPath.exists() && fPath.isRegularFile() && fPath.isReadable())
    val tag = Tag.getTag(fPath.absolutePathString())

    if (tag is Id3v2Tag) println(printTag(tag)) else println(tag)

    assertAll("Should find the same values",
              { assertEquals(fileType, tag.tagVersion.specification) },
              { assertEquals(album, tag.album) },
              { assertEquals(artist, tag.artist) },
              { assertEquals(genre, tag.genre) },
              { assertEquals(year?.toString(), tag.year) }
    )
  }

  @AfterEach
  fun cleanUp()
  {
    System.gc()
  }
}
