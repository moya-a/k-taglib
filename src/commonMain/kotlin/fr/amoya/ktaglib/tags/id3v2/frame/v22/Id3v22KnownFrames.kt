package fr.amoya.ktaglib.tags.id3v2.frame.v22

import fr.amoya.ktaglib.tags.id3v2.frame.Id3v2KnownFrame


/*
* fr.amoya.ktaglib.tags.id3v2
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/


enum class Id3v22KnownFrames(open val description: String) : Id3v2KnownFrame
{
  BUF("Recommended buffer size"),

  CNT("Play counter"),
  COM("Comments"),
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

  TAL("Album/Movie/Show title"),
  TBP("BPM (Beats Per Minute)"),
  TCM("Composer"),
  TCO("Content type"),
  TCR("Copyright message"),
  TDA("Date"),
  TDY("Playlist delay"),
  TEN("Encoded by"),
  TFT("File type"),
  TIM("Time"),
  TKE("Initial key"),
  TLA("Language(s)"),
  TLE("Length"),
  TMT("Media type"),
  TOA("Original artist(s)/performer(s)"),
  TOF("Original filename"),
  TOL("Original Lyricist(s)/text writer(s)"),
  TOR("Original release year"),
  TOT("Original album/Movie/Show title"),
  TP1("Lead artist(s)/Lead performer(s)/Soloist(s)/Performing group"),
  TP2("Band/Orchestra/Accompaniment"),
  TP3("Conductor/Performer refinement"),
  TP4("Interpreted, remixed, or otherwise modified by"),
  TPA("Part of a set"),
  TPB("Publisher"),
  TRC("ISRC (International Standard Recording Code)"),
  TRD("Recording dates"),
  TRK("Track number/Position in set"),
  TSI("Size"),
  TSS("Software/hardware and settings used for encoding"),
  TT1("Content group description"),
  TT2("Title/Songname/Content description"),
  TT3("Subtitle/Description refinement"),
  TXT("Lyricist/text writer"),
  TXX("User defined text information frame"),
  TYE("Year"),

  UFI("Unique file identifier"),
  ULT("Unsychronized lyric/text transcription"),

  WAF("Official audio file webpage"),
  WAR("Official artist/performer webpage"),
  WAS("Official audio source webpage"),
  WCM("Commercial information"),
  WCP("Copyright/Legal information"),
  WPB("Publishers official webpage"),
  WXX("User defined URL link frame"),
}
