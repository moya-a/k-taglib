package fr.amoya.ktaglib.common.parsers

import fr.amoya.ktaglib.common.tags.Tag
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvFileSource
import java.util.stream.Stream
import kotlin.io.path.*
import kotlin.test.assertEquals


/*
* fr.amoya.ktaglib.common.parsers
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/

data class ExpectedResult(
  val filename: String,
  val fileType: String?,
  val no: Int?,
  val bitrate: Int?,
  val title: String?,
  val album: String?,
  val artist: String?,
  val genre: String?,
  val year: Int?,
  val duration: Int?
)

data class Argument(
  val filename: String,
  val expectedResult: ExpectedResult,
  val tag: Tag?
)

@ExperimentalUnsignedTypes
@ExperimentalPathApi
internal class TagParserTest
{

  companion object CSVLoader
  {
    @JvmStatic
    val tagsAndResults: MutableList<Arguments> = mutableListOf()

    @BeforeAll
    @JvmStatic
    internal fun setUp()
    {
      val csvPath = Path("src", "commonTest", "resources", "expected_results.csv")
      println(csvPath.absolutePathString())
      csvPath.readLines().forEachIndexed { i, row ->
        if (i > 0)
        {
          try
          {
            val csvEntries = row.split(",")
            val result = ExpectedResult(
              filename = csvEntries[0],
              fileType = csvEntries[1],
              no = csvEntries[2].toIntOrNull(),
              bitrate = csvEntries[3].toIntOrNull(),
              title = csvEntries[4],
              album = csvEntries[5],
              artist = csvEntries[6],
              genre = csvEntries[7],
              year = csvEntries[8].toIntOrNull(),
              duration = csvEntries[9].toIntOrNull()
            )
            val fPath = Path("src", "commonTest", "resources", "data", result.filename)
            tagsAndResults.add(Arguments.of(result, Tag.getTagOrNull(fPath.absolutePathString())))
          }
          catch (e: Exception)
          {
            println(e)
          }
        }
      }
      println("added ${tagsAndResults.size} entries")
    }

    @JvmStatic
    fun testTagProvider(): Stream<Arguments> = tagsAndResults.stream()
  }


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

    // if (tag is Id3v2Tag) println(printTag(tag)) else println(tag)

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
