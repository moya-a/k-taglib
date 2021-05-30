package fr.amoya.ktaglib.common.tags.id3.id3v2.frame.v23

import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3FrameContent
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.Id3v2KnownFrames
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.commentParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.privateParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.textParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.urlParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.userTextParser
import fr.amoya.ktaglib.common.tags.id3.id3v2.frame.contentFrames.Id3FrameContentParsers.userUrlParser


/*
* fr.amoya.ktaglib.tags.id3v2.frame
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

enum class Id3v23KnownFrames(
  override val description: String,
  override val parser: (ByteArray) -> Id3FrameContent = Id3FrameContentParsers::rawParser
) : Id3v2KnownFrames
{
  NONE("Unknown Frame"),

  AENC("Audio encryption"),
  APIC("Attached picture"),

  COMM("Comments", ::commentParser),
  COMR("Commercial frame"),

  ENCR("Encryption method registration"),
  EQUA("Equalization"),
  ETCO("Event timing codes"),

  GEOB("General encapsulated object"),
  GRID("Group identification registration"),

  IPLS("Involved people list"),

  LINK("Linked information"),

  MCDI("Music CD identifier"),
  MLLT("MPEG location lookup table"),

  OWNE("Ownership frame"),

  PRIV("Private frame", ::privateParser),
  PCNT("Play counter"),
  POPM("Popularimeter"),
  POSS("Position synchronisation frame"),

  RBUF("Recommended buffer size"),
  RVAD("Relative volume adjustment"),
  RVRB("Reverb"),

  SYLT("Synchronized lyric/text"),
  SYTC("Synchronized tempo codes"),

  TALB("Album/Movie/Show title", ::textParser),
  TBPM("BPM (beats per minute)", ::textParser),
  TCOM("Composer", ::textParser),
  TCON("Content type", ::textParser),
  TCOP("Copyright message", ::textParser),
  TDAT("Date", ::textParser),
  TDLY("Playlist delay", ::textParser),
  TENC("Encoded by", ::textParser),
  TEXT("Lyricist/Text writer", ::textParser),
  TFLT("File type", ::textParser),
  TIME("Time", ::textParser),
  TIT1("Content group description", ::textParser),
  TIT2("Title/songname/content description", ::textParser),
  TIT3("Subtitle/Description refinement", ::textParser),
  TKEY("Initial key", ::textParser),
  TLAN("Language(s)", ::textParser),
  TLEN("Length", ::textParser),
  TMED("Media type", ::textParser),
  TOAL("Original album/movie/show title", ::textParser),
  TOFN("Original filename", ::textParser),
  TOLY("Original lyricist(s)/text writer(s)", ::textParser),
  TOPE("Original artist(s)/performer(s)", ::textParser),
  TORY("Original release year", ::textParser),
  TOWN("File owner/licensee", ::textParser),
  TPE1("Lead performer(s)/Soloist(s)", ::textParser),
  TPE2("Band/orchestra/accompaniment", ::textParser),
  TPE3("Conductor/performer refinement", ::textParser),
  TPE4("Interpreted, remixed, or otherwise modified by", ::textParser),
  TPOS("Part of a set", ::textParser),
  TPUB("Publisher", ::textParser),
  TRCK("Track number/Position in set", ::textParser),
  TRDA("Recording dates", ::textParser),
  TRSN("Internet radio station name", ::textParser),
  TRSO("Internet radio station owner", ::textParser),
  TSIZ("Size", ::textParser),
  TSRC("ISRC (international standard recording code)", ::textParser),
  TSSE("Software/Hardware and settings used for encoding", ::textParser),
  TYER("Year", ::textParser),

  TXXX("User defined text information frame", ::userTextParser),

  UFID("Unique file identifier"),
  USER("Terms of use"),
  USLT("Unsychronized lyric/text transcription"),

  WCOM("Commercial information", ::urlParser),
  WCOP("Copyright/Legal information", ::urlParser),
  WOAF("Official audio file webpage"),
  WOAR("Official artist/performer webpage", ::urlParser),
  WOAS("Official audio source webpage", ::urlParser),
  WORS("Official internet radio station homepage", ::urlParser),
  WPAY("Payment", ::urlParser),
  WPUB("Publishers official webpage", ::urlParser),

  WXXX("User defined URL link frame", ::userUrlParser)
}
