package fr.amoya.ktaglib.tag.id3.id3v2.v24

import fr.amoya.ktaglib.tag.frameContentParserFn
import fr.amoya.ktaglib.tag.id3.id3v2.Id3v2KnownFrames
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.commentParser
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.privateParser
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.textParser
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.urlParser
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.userTextParser
import fr.amoya.ktaglib.tag.id3.id3v2.contentFrames.Id3v2FrameContentParsers.userUrlParser


/*
* fr.amoya.ktaglib.tags.id3v2.frame
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 04/05/2021
*/

enum class Id3v24KnownFrames(
  override val description: String,
  override val parser: frameContentParserFn = Id3v2FrameContentParsers::rawParser
) : Id3v2KnownFrames
{

  NONE("Unknown Frame"),

  AENC("Audio encryption"),
  APIC("Attached picture"),
  ASPI("Audio seek point index"),

  COMM("Comments", ::commentParser),
  COMR("Commercial frame"),

  ENCR("Encryption method registration"),
  EQU2("Equalisation (2)"),
  ETCO("Event timing codes"),

  GEOB("General encapsulated object"),
  GRID("Group identification registration"),

  LINK("Linked information"),

  MCDI("Music CD identifier"),
  MLLT("MPEG location lookup table"),

  OWNE("Ownership frame"),

  PRIV("Private frame", ::privateParser),
  PCNT("Play counter"),
  POPM("Popularimeter"),
  POSS("Position synchronisation frame"),

  RBUF("Recommended buffer size"),
  RVA2("Relative volume adjustment (2)"),
  RVRB("Reverb"),

  SEEK("Seek frame"),
  SIGN("Signature frame"),
  SYLT("Synchronised lyric/text"),
  SYTC("Synchronised tempo codes"),

  TALB("Album/Movie/Show title", ::textParser),
  TBPM("BPM (beats per minute)", ::textParser),
  TCOM("Composer", ::textParser),
  TCON("Content type", ::textParser),
  TCOP("Copyright message", ::textParser),
  TDEN("Encoding time", ::textParser),
  TDLY("Playlist delay", ::textParser),
  TDOR("Original release time", ::textParser),
  TDRC("Recording time", ::textParser),
  TDRL("Release time", ::textParser),
  TDTG("Tagging time", ::textParser),
  TENC("Encoded by", ::textParser),
  TEXT("Lyricist/Text writer", ::textParser),
  TFLT("File type", ::textParser),
  TIPL("Involved people list", ::textParser),
  TIT1("Content group description", ::textParser),
  TIT2("Title/songname/content description", ::textParser),
  TIT3("Subtitle/Description refinement", ::textParser),
  TKEY("Initial key", ::textParser),
  TLAN("Language(s)", ::textParser),
  TLEN("Length", ::textParser),
  TMCL("Musician credits list", ::textParser),
  TMED("Media type", ::textParser),
  TMOO("Mood", ::textParser),
  TOAL("Original album/movie/show title", ::textParser),
  TOFN("Original filename", ::textParser),
  TOLY("Original lyricist(s)/text writer(s)", ::textParser),
  TOPE("Original artist(s)/performer(s)", ::textParser),
  TOWN("File owner/licensee", ::textParser),
  TPE1("Lead performer(s)/Soloist(s)", ::textParser),
  TPE2("Band/orchestra/accompaniment", ::textParser),
  TPE3("Conductor/performer refinement", ::textParser),
  TPE4("Interpreted, remixed, or otherwise modified by", ::textParser),
  TPOS("Part of a set", ::textParser),
  TPRO("Produced notice", ::textParser),
  TPUB("Publisher", ::textParser),
  TRCK("Track number/Position in set", ::textParser),
  TRSN("Internet radio station name", ::textParser),
  TRSO("Internet radio station owner", ::textParser),
  TSOA("Album sort order", ::textParser),
  TSOP("Performer sort order", ::textParser),
  TSOT("Title sort order", ::textParser),
  TSRC("ISRC (international standard recording code)", ::textParser),
  TSSE("Software/Hardware and settings used for encoding", ::textParser),
  TSST("Set subtitle", ::textParser),

  TXXX("User defined text information frame", ::userTextParser),

  UFID("Unique file identifier"),
  USER("Terms of use"),
  USLT("Unsynchronised lyric/text transcription"),

  WCOM("Commercial information", ::urlParser),
  WCOP("Copyright/Legal information", ::urlParser),
  WOAF("Official audio file webpage", ::urlParser),
  WOAR("Official artist/performer webpage", ::urlParser),
  WOAS("Official audio source webpage", ::urlParser),
  WORS("Official Internet radio station homepage", ::urlParser),
  WPAY("Payment", ::urlParser),
  WPUB("Publishers official webpage", ::urlParser),

  WXXX("User defined URL link frame", ::userUrlParser)
}
