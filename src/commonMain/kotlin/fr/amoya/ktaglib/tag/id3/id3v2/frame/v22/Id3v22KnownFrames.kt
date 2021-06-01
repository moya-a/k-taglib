package fr.amoya.ktaglib.tag.id3.id3v2.frame.v22

import fr.amoya.ktaglib.tag.frameContentParserFn
import fr.amoya.ktaglib.tag.id3.id3v2.frame.Id3v2KnownFrames
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.commentParser
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.rawParser
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.textParser
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.urlParser
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.userTextParser
import fr.amoya.ktaglib.tag.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.userUrlParser


/*
* fr.amoya.ktaglib.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

enum class Id3v22KnownFrames(
  override val description: String,
  override val parser: frameContentParserFn = ::rawParser
) : Id3v2KnownFrames
{
  NONE("Unknown Frame"),

  BUF("Recommended buffer size"),

  CNT("Play counter"),
  COM("Comments", ::commentParser),
  CRA("Audio encryption"),
  CRM("Encrypted meta frame"),

  ETC("Event timing codes"),
  EQU("Equalization"),

  GEO("General encapsulated object"),

  IPL("Involved people list"),

  LNK("Linked information"),

  MCI("Music CD Identifier"),
  MLL("MPEG location lookup table"),

  PIC("Attached picture"),
  POP("Popularimeter"),

  REV("Reverb"),
  RVA("Relative volume adjustment"),

  SLT("Synchronized lyric/text"),
  STC("Synced tempo codes"),

  TAL("Album/Movie/Show title", ::textParser),
  TBP("BPM (Beats Per Minute)", ::textParser),
  TCM("Composer", ::textParser),
  TCO("Content type", ::textParser),
  TCR("Copyright message", ::textParser),
  TDA("Date", ::textParser),
  TDY("Playlist delay", ::textParser),
  TEN("Encoded by", ::textParser),
  TFT("File type", ::textParser),
  TIM("Time", ::textParser),
  TKE("Initial key", ::textParser),
  TLA("Language(s)", ::textParser),
  TLE("Length", ::textParser),
  TMT("Media type", ::textParser),
  TOA("Original artist(s)/performer(s)", ::textParser),
  TOF("Original filename", ::textParser),
  TOL("Original Lyricist(s)/text writer(s)", ::textParser),
  TOR("Original release year", ::textParser),
  TOT("Original album/Movie/Show title", ::textParser),
  TP1("Lead artist(s)/Lead performer(s)/Soloist(s)/Performing group", ::textParser),
  TP2("Band/Orchestra/Accompaniment", ::textParser),
  TP3("Conductor/Performer refinement", ::textParser),
  TP4("Interpreted, remixed, or otherwise modified by", ::textParser),
  TPA("Part of a set", ::textParser),
  TPB("Publisher", ::textParser),
  TRC("ISRC (International Standard Recording Code)", ::textParser),
  TRD("Recording dates", ::textParser),
  TRK("Track number/Position in set", ::textParser),
  TSI("Size", ::textParser),
  TSS("Software/hardware and settings used for encoding", ::textParser),
  TT1("Content group description", ::textParser),
  TT2("Title/Songname/Content description", ::textParser),
  TT3("Subtitle/Description refinement", ::textParser),
  TXT("Lyricist/text writer", ::textParser),
  TYE("Year", ::textParser),

  TXX("User defined text information frame", ::userTextParser),

  UFI("Unique file identifier"),
  ULT("Unsychronized lyric/text transcription"),

  WAF("Official audio file webpage", ::urlParser),
  WAR("Official artist/performer webpage", ::urlParser),
  WAS("Official audio source webpage", ::urlParser),
  WCM("Commercial information", ::urlParser),
  WCP("Copyright/Legal information", ::urlParser),
  WPB("Publishers official webpage", ::urlParser),

  WXX("User defined URL link frame", ::userUrlParser),
}
