package fr.amoya.ktaglib.common.parsers

import fr.amoya.ktaglib.common.tags.Tag
import org.junit.jupiter.api.*
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
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
  val fileType: String,
  val no: String?,
  val bitrate: String?,
  val title: String?,
  val album: String?,
  val artist: String?,
  val genre: String?,
  val year: String?,
  val duration: String?
)

@ExperimentalUnsignedTypes
@ExperimentalPathApi
internal class TagParserTest
{

  companion object
  {
    @JvmStatic
    val tagsAndResults: MutableList<Pair<ExpectedResult, Tag?>> = mutableListOf()

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
              no = csvEntries[2],
              bitrate = csvEntries[3],
              title = csvEntries[4],
              album = csvEntries[5],
              artist = csvEntries[6],
              genre = csvEntries[7],
              year = csvEntries[8],
              duration = csvEntries[9]
            )
            val fPath = Path("src", "commonTest", "resources", "data", csvEntries[0])
            tagsAndResults.add(Pair(result, Tag.getTagOrNull(fPath.absolutePathString())))
          }
          catch (e: Exception)
          {
            println(e)
          }
        }
      }
      println("added ${tagsAndResults.size} entries")
    }

    private fun Any?.toStringOrEmpty(): String = this?.run { this.toString() } ?: ""

    @JvmStatic
    fun testTagProvider(): Stream<Arguments> =
      tagsAndResults.map { Arguments.of(it.first.filename, it.first, it.second) }.stream()

    @JvmStatic
    fun testSpecProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.fileType,
          it.second?.tagVersion?.specification ?: "NONE",
          it.first.filename
        )
      }.stream()

    @JvmStatic
    fun testTitleProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.title.toStringOrEmpty(),
          it.second?.title.toStringOrEmpty(),
          it.first.filename,
          it.first.fileType
        )
      }.stream()

    @JvmStatic
    fun testArtistProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.artist.toStringOrEmpty(),
          it.second?.artist.toStringOrEmpty(),
          it.first.filename,
          it.first.fileType
        )
      }.stream()

    @JvmStatic
    fun testAlbumProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.album.toStringOrEmpty(),
          it.second?.album.toStringOrEmpty(),
          it.first.filename,
          it.first.fileType
        )
      }.stream()

    @JvmStatic
    fun testGenreProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.genre.toStringOrEmpty(),
          it.second?.genre.toStringOrEmpty(),
          it.first.filename,
          it.first.fileType
        )
      }.stream()

    @JvmStatic
    fun testYearProvider(): Stream<Arguments> =
      tagsAndResults.map {
        Arguments.of(
          it.first.year.toStringOrEmpty(),
          it.second?.year.toStringOrEmpty(),
          it.first.filename,
          it.first.fileType
        )
      }.stream()
  }


  /*
  ** Error Checking
  */
  @ParameterizedTest(name = "Should throw an error : {0}")
  @DisplayName("Should throw an error : {0}")
  @MethodSource("testTagProvider")
  fun shouldThrowAnError(filename: String, result: ExpectedResult)
  {
    val fPath = Path("src", "commonTest", "resources", "data", filename)
    Assumptions.assumingThat(!(fPath.exists() && fPath.isRegularFile() && fPath.isReadable()))
    {
      assertThrows<IllegalArgumentException> { Tag.getTag(fPath.absolutePathString()) }
    }
    Assumptions.assumingThat(
      fPath.exists() && fPath.isRegularFile() && fPath.isReadable() &&
      !result.fileType.contains("ID3") &&
      (result.fileType.contains("FLAC") || result.fileType.contains("RIFF") ||
       result.fileType.contains("OGG") || result.fileType.contains("APE"))
    )
    {
      assertThrows<NotImplementedError> { Tag.getTag(fPath.absolutePathString()) }
    }
  }

  @ParameterizedTest(name = "Should not throw an error : {0}")
  @DisplayName("Should not throw an error : {0}")
  @MethodSource("testTagProvider")
  fun shouldNotThrowAnError(filename: String, result: ExpectedResult)
  {
    val fPath = Path("src", "commonTest", "resources", "data", filename)
    Assumptions.assumingThat(
      fPath.exists() && fPath.isRegularFile() && fPath.isReadable() && result.fileType.contains("ID3")
    )
    {
      assertDoesNotThrow { Tag.getTag(fPath.absolutePathString()) }
    }
  }


  /*
  ** Actual Parsing Check
  */
  @ParameterizedTest(name = "[SPEC] ({2}) : {0} == {1}")
  @DisplayName("Should return Tag Specification")
  @MethodSource("testSpecProvider")
  fun shouldReturnTagSpecification(expected: String?, result: String?, filename: String)
  {
    Assumptions.assumeTrue(expected?.contains(Regex("(ID3|FLAC|RIFF)")) ?: false && filename.isNotEmpty())
    assertEquals(expected, result)
  }

  @ParameterizedTest(name = "[TITLE] ({2}) : {0} == {1}")
  @DisplayName("Should return title : {0}")
  @MethodSource("testTitleProvider")
  fun shouldReturnTitle(expectedTitle: String?, result: String?, filename: String, fileType: String)
  {
    Assumptions.assumeTrue(fileType.contains("ID3") && filename.isNotEmpty())
    assertEquals(expectedTitle, result)
  }

  @ParameterizedTest(name = "[ARTIST] ({2}) : {0} == {1}")
  @DisplayName("Should return artist : {0}")
  @MethodSource("testArtistProvider")
  fun shouldReturnArtist(expectedArtist: String?, result: String?, filename: String, fileType: String)
  {
    Assumptions.assumeTrue(fileType.contains("ID3") && filename.isNotEmpty())
    assertEquals(expectedArtist, result)
  }

  @ParameterizedTest(name = "[ALBUM] ({2}) : {0} == {1}")
  @DisplayName("Should return album : {0}")
  @MethodSource("testAlbumProvider")
  fun shouldReturnAlbum(expectedAlbum: String?, result: String?, filename: String, fileType: String)
  {
    Assumptions.assumeTrue(fileType.contains("ID3") && filename.isNotEmpty())
    assertEquals(expectedAlbum, result)
  }

  @ParameterizedTest(name = "[GENRE] ({2}) : {0} == {1}")
  @DisplayName("Should return genre : {0}")
  @MethodSource("testGenreProvider")
  fun shouldReturnGenre(expectedGenre: String?, result: String?, filename: String, fileType: String)
  {
    Assumptions.assumeTrue(fileType.contains("ID3") && filename.isNotEmpty())
    assertEquals(expectedGenre, result)
  }

  @ParameterizedTest(name = "[YEAR] ({2}) : {0} == {1}")
  @DisplayName("Should return year : {0}")
  @MethodSource("testYearProvider")
  fun shouldReturnYear(expectedYear: String?, result: String?, filename: String, fileType: String)
  {
    Assumptions.assumeTrue(fileType.contains("ID3") && filename.isNotEmpty())
    assertEquals(expectedYear, result)
  }


  @AfterEach
  fun cleanUp()
  {
    System.gc()
  }
}
