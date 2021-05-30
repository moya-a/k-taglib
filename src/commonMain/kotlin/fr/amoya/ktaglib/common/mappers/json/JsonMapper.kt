package fr.amoya.ktaglib.common.mappers.json

import fr.amoya.ktaglib.common.Tag
import fr.amoya.ktaglib.common.tags.id3.id3v1.Id3v1Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.Id3v22Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.Id3v23Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.Id3v24Tag
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v22.Id3v22FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23.Id3v23FrameHeader
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v24.Id3v24FrameHeader
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.polymorphic
import kotlinx.serialization.modules.subclass

object JsonMapper
{
  val format by lazy {
    Json {
      prettyPrint = true
      serializersModule = SerializersModule {
        polymorphic(Tag::class) {
          subclass(Id3v1Tag::class)
          subclass(Id3v22Tag::class)
          subclass(Id3v23Tag::class)
          subclass(Id3v24Tag::class)
        }
        polymorphic(Id3FrameHeader::class) {
          subclass(Id3v22FrameHeader::class)
          subclass(Id3v23FrameHeader::class)
          subclass(Id3v24FrameHeader::class)
        }
      }
    }
  }
}
