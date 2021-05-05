package fr.amoya.ktaglib.common.tags.id3v1


/*
* fr.amoya.ktaglib.common.tags.id3v1
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 05/05/2021
*/
object Id3v1KnownGenre
{
  fun getGenre(genreCode: Int): Id3v1KnownGenres =
    when (genreCode)
    {
      Id3v1KnownGenres.BLUES.genreCode                  -> Id3v1KnownGenres.BLUES
      Id3v1KnownGenres.CLASSIC_ROCK.genreCode           -> Id3v1KnownGenres.CLASSIC_ROCK
      Id3v1KnownGenres.COUNTRY.genreCode                -> Id3v1KnownGenres.COUNTRY
      Id3v1KnownGenres.DANCE.genreCode                  -> Id3v1KnownGenres.DANCE
      Id3v1KnownGenres.DISCO.genreCode                  -> Id3v1KnownGenres.DISCO
      Id3v1KnownGenres.FUNK.genreCode                   -> Id3v1KnownGenres.FUNK
      Id3v1KnownGenres.GRUNGE.genreCode                 -> Id3v1KnownGenres.GRUNGE
      Id3v1KnownGenres.HIP_HOP.genreCode                -> Id3v1KnownGenres.HIP_HOP
      Id3v1KnownGenres.JAZZ.genreCode                   -> Id3v1KnownGenres.JAZZ
      Id3v1KnownGenres.METAL.genreCode                  -> Id3v1KnownGenres.METAL
      Id3v1KnownGenres.NEW_AGE.genreCode                -> Id3v1KnownGenres.NEW_AGE
      Id3v1KnownGenres.OLDIES.genreCode                 -> Id3v1KnownGenres.OLDIES
      Id3v1KnownGenres.OTHER.genreCode                  -> Id3v1KnownGenres.OTHER
      Id3v1KnownGenres.POP.genreCode                    -> Id3v1KnownGenres.POP
      Id3v1KnownGenres.RHYTHM_AND_BLUES.genreCode       -> Id3v1KnownGenres.RHYTHM_AND_BLUES
      Id3v1KnownGenres.RAP.genreCode                    -> Id3v1KnownGenres.RAP
      Id3v1KnownGenres.REGGAE.genreCode                 -> Id3v1KnownGenres.REGGAE
      Id3v1KnownGenres.ROCK.genreCode                   -> Id3v1KnownGenres.ROCK
      Id3v1KnownGenres.TECHNO.genreCode                 -> Id3v1KnownGenres.TECHNO
      Id3v1KnownGenres.INDUSTRIAL.genreCode             -> Id3v1KnownGenres.INDUSTRIAL
      Id3v1KnownGenres.ALTERNATIVE.genreCode            -> Id3v1KnownGenres.ALTERNATIVE
      Id3v1KnownGenres.SKA.genreCode                    -> Id3v1KnownGenres.SKA
      Id3v1KnownGenres.DEATH_METAL.genreCode            -> Id3v1KnownGenres.DEATH_METAL
      Id3v1KnownGenres.PRANKS.genreCode                 -> Id3v1KnownGenres.PRANKS
      Id3v1KnownGenres.SOUNDTRACK.genreCode             -> Id3v1KnownGenres.SOUNDTRACK
      Id3v1KnownGenres.EURO_TECHNO.genreCode            -> Id3v1KnownGenres.EURO_TECHNO
      Id3v1KnownGenres.AMBIENT.genreCode                -> Id3v1KnownGenres.AMBIENT
      Id3v1KnownGenres.TRIP_HOP.genreCode               -> Id3v1KnownGenres.TRIP_HOP
      Id3v1KnownGenres.VOCAL.genreCode                  -> Id3v1KnownGenres.VOCAL
      Id3v1KnownGenres.JAZZ_AND_FUNK.genreCode          -> Id3v1KnownGenres.JAZZ_AND_FUNK
      Id3v1KnownGenres.FUSION.genreCode                 -> Id3v1KnownGenres.FUSION
      Id3v1KnownGenres.TRANCE.genreCode                 -> Id3v1KnownGenres.TRANCE
      Id3v1KnownGenres.CLASSICAL.genreCode              -> Id3v1KnownGenres.CLASSICAL
      Id3v1KnownGenres.INSTRUMENTAL.genreCode           -> Id3v1KnownGenres.INSTRUMENTAL
      Id3v1KnownGenres.ACID.genreCode                   -> Id3v1KnownGenres.ACID
      Id3v1KnownGenres.HOUSE.genreCode                  -> Id3v1KnownGenres.HOUSE
      Id3v1KnownGenres.GAME.genreCode                   -> Id3v1KnownGenres.GAME
      Id3v1KnownGenres.SOUND_CLIP.genreCode             -> Id3v1KnownGenres.SOUND_CLIP
      Id3v1KnownGenres.GOSPEL.genreCode                 -> Id3v1KnownGenres.GOSPEL
      Id3v1KnownGenres.NOISE.genreCode                  -> Id3v1KnownGenres.NOISE
      Id3v1KnownGenres.ALTERNATIVE_ROCK.genreCode       -> Id3v1KnownGenres.ALTERNATIVE_ROCK
      Id3v1KnownGenres.BASS.genreCode                   -> Id3v1KnownGenres.BASS
      Id3v1KnownGenres.SOUL.genreCode                   -> Id3v1KnownGenres.SOUL
      Id3v1KnownGenres.PUNK.genreCode                   -> Id3v1KnownGenres.PUNK
      Id3v1KnownGenres.SPACE.genreCode                  -> Id3v1KnownGenres.SPACE
      Id3v1KnownGenres.MEDITATIVE.genreCode             -> Id3v1KnownGenres.MEDITATIVE
      Id3v1KnownGenres.INSTRUMENTAL_POP.genreCode       -> Id3v1KnownGenres.INSTRUMENTAL_POP
      Id3v1KnownGenres.INSTRUMENTAL_ROCK.genreCode      -> Id3v1KnownGenres.INSTRUMENTAL_ROCK
      Id3v1KnownGenres.ETHNIC.genreCode                 -> Id3v1KnownGenres.ETHNIC
      Id3v1KnownGenres.GOTHIC.genreCode                 -> Id3v1KnownGenres.GOTHIC
      Id3v1KnownGenres.DARKWAVE.genreCode               -> Id3v1KnownGenres.DARKWAVE
      Id3v1KnownGenres.TECHNO_INDUSTRIAL.genreCode      -> Id3v1KnownGenres.TECHNO_INDUSTRIAL
      Id3v1KnownGenres.ELECTRONIC.genreCode             -> Id3v1KnownGenres.ELECTRONIC
      Id3v1KnownGenres.POP_FOLK.genreCode               -> Id3v1KnownGenres.POP_FOLK
      Id3v1KnownGenres.EURODANCE.genreCode              -> Id3v1KnownGenres.EURODANCE
      Id3v1KnownGenres.DREAM.genreCode                  -> Id3v1KnownGenres.DREAM
      Id3v1KnownGenres.SOUTHERN_ROCK.genreCode          -> Id3v1KnownGenres.SOUTHERN_ROCK
      Id3v1KnownGenres.COMEDY.genreCode                 -> Id3v1KnownGenres.COMEDY
      Id3v1KnownGenres.CULT.genreCode                   -> Id3v1KnownGenres.CULT
      Id3v1KnownGenres.GANGSTA.genreCode                -> Id3v1KnownGenres.GANGSTA
      Id3v1KnownGenres.TOP_40.genreCode                 -> Id3v1KnownGenres.TOP_40
      Id3v1KnownGenres.CHRISTIAN_RAP.genreCode          -> Id3v1KnownGenres.CHRISTIAN_RAP
      Id3v1KnownGenres.POP_FUNK.genreCode               -> Id3v1KnownGenres.POP_FUNK
      Id3v1KnownGenres.JUNGLE_MUSIC.genreCode           -> Id3v1KnownGenres.JUNGLE_MUSIC
      Id3v1KnownGenres.NATIVE_US.genreCode              -> Id3v1KnownGenres.NATIVE_US
      Id3v1KnownGenres.CABARET.genreCode                -> Id3v1KnownGenres.CABARET
      Id3v1KnownGenres.NEW_WAVE.genreCode               -> Id3v1KnownGenres.NEW_WAVE
      Id3v1KnownGenres.PSYCHEDELIC.genreCode            -> Id3v1KnownGenres.PSYCHEDELIC
      Id3v1KnownGenres.RAVE.genreCode                   -> Id3v1KnownGenres.RAVE
      Id3v1KnownGenres.SHOWTUNES.genreCode              -> Id3v1KnownGenres.SHOWTUNES
      Id3v1KnownGenres.TRAILER.genreCode                -> Id3v1KnownGenres.TRAILER
      Id3v1KnownGenres.LO_FI.genreCode                  -> Id3v1KnownGenres.LO_FI
      Id3v1KnownGenres.TRIBAL.genreCode                 -> Id3v1KnownGenres.TRIBAL
      Id3v1KnownGenres.ACID_PUNK.genreCode              -> Id3v1KnownGenres.ACID_PUNK
      Id3v1KnownGenres.ACID_JAZZ.genreCode              -> Id3v1KnownGenres.ACID_JAZZ
      Id3v1KnownGenres.POLKA.genreCode                  -> Id3v1KnownGenres.POLKA
      Id3v1KnownGenres.RETRO.genreCode                  -> Id3v1KnownGenres.RETRO
      Id3v1KnownGenres.MUSICAL.genreCode                -> Id3v1KnownGenres.MUSICAL
      Id3v1KnownGenres.ROCK_N_ROLL.genreCode            -> Id3v1KnownGenres.ROCK_N_ROLL
      Id3v1KnownGenres.HARD_ROCK.genreCode              -> Id3v1KnownGenres.HARD_ROCK
      Id3v1KnownGenres.FOLK.genreCode                   -> Id3v1KnownGenres.FOLK
      Id3v1KnownGenres.FOLK_ROCK.genreCode              -> Id3v1KnownGenres.FOLK_ROCK
      Id3v1KnownGenres.NATIONAL_FOLK.genreCode          -> Id3v1KnownGenres.NATIONAL_FOLK
      Id3v1KnownGenres.SWING.genreCode                  -> Id3v1KnownGenres.SWING
      Id3v1KnownGenres.FAST_FUSION.genreCode            -> Id3v1KnownGenres.FAST_FUSION
      Id3v1KnownGenres.BEBOP.genreCode                  -> Id3v1KnownGenres.BEBOP
      Id3v1KnownGenres.LATIN.genreCode                  -> Id3v1KnownGenres.LATIN
      Id3v1KnownGenres.REVIVAL.genreCode                -> Id3v1KnownGenres.REVIVAL
      Id3v1KnownGenres.CELTIC.genreCode                 -> Id3v1KnownGenres.CELTIC
      Id3v1KnownGenres.BLUEGRASS.genreCode              -> Id3v1KnownGenres.BLUEGRASS
      Id3v1KnownGenres.AVANTGARDE.genreCode             -> Id3v1KnownGenres.AVANTGARDE
      Id3v1KnownGenres.GOTHIC_ROCK.genreCode            -> Id3v1KnownGenres.GOTHIC_ROCK
      Id3v1KnownGenres.PROGRESSIVE_ROCK.genreCode       -> Id3v1KnownGenres.PROGRESSIVE_ROCK
      Id3v1KnownGenres.PSYCHEDELIC_ROCK.genreCode       -> Id3v1KnownGenres.PSYCHEDELIC_ROCK
      Id3v1KnownGenres.SYMPHONIC_ROCK.genreCode         -> Id3v1KnownGenres.SYMPHONIC_ROCK
      Id3v1KnownGenres.SLOW_ROCK.genreCode              -> Id3v1KnownGenres.SLOW_ROCK
      Id3v1KnownGenres.BIG_BAND.genreCode               -> Id3v1KnownGenres.BIG_BAND
      Id3v1KnownGenres.CHORUS.genreCode                 -> Id3v1KnownGenres.CHORUS
      Id3v1KnownGenres.EASY_LISTENING.genreCode         -> Id3v1KnownGenres.EASY_LISTENING
      Id3v1KnownGenres.ACOUSTIC.genreCode               -> Id3v1KnownGenres.ACOUSTIC
      Id3v1KnownGenres.HUMOUR.genreCode                 -> Id3v1KnownGenres.HUMOUR
      Id3v1KnownGenres.SPEECH.genreCode                 -> Id3v1KnownGenres.SPEECH
      Id3v1KnownGenres.CHANSON.genreCode                -> Id3v1KnownGenres.CHANSON
      Id3v1KnownGenres.OPERA.genreCode                  -> Id3v1KnownGenres.OPERA
      Id3v1KnownGenres.CHAMBER_MUSIC.genreCode          -> Id3v1KnownGenres.CHAMBER_MUSIC
      Id3v1KnownGenres.SONATA.genreCode                 -> Id3v1KnownGenres.SONATA
      Id3v1KnownGenres.SYMPHONY.genreCode               -> Id3v1KnownGenres.SYMPHONY
      Id3v1KnownGenres.BOOTY_BASS.genreCode             -> Id3v1KnownGenres.BOOTY_BASS
      Id3v1KnownGenres.PRIMUS.genreCode                 -> Id3v1KnownGenres.PRIMUS
      Id3v1KnownGenres.PORN_GROOVE.genreCode            -> Id3v1KnownGenres.PORN_GROOVE
      Id3v1KnownGenres.SATIRE.genreCode                 -> Id3v1KnownGenres.SATIRE
      Id3v1KnownGenres.SLOW_JAM.genreCode               -> Id3v1KnownGenres.SLOW_JAM
      Id3v1KnownGenres.CLUB.genreCode                   -> Id3v1KnownGenres.CLUB
      Id3v1KnownGenres.TANGO.genreCode                  -> Id3v1KnownGenres.TANGO
      Id3v1KnownGenres.SAMBA.genreCode                  -> Id3v1KnownGenres.SAMBA
      Id3v1KnownGenres.FOLKLORE.genreCode               -> Id3v1KnownGenres.FOLKLORE
      Id3v1KnownGenres.BALLAD.genreCode                 -> Id3v1KnownGenres.BALLAD
      Id3v1KnownGenres.POWER_BALLAD.genreCode           -> Id3v1KnownGenres.POWER_BALLAD
      Id3v1KnownGenres.RHYTHMIC_SOUL.genreCode          -> Id3v1KnownGenres.RHYTHMIC_SOUL
      Id3v1KnownGenres.FREESTYLE.genreCode              -> Id3v1KnownGenres.FREESTYLE
      Id3v1KnownGenres.DUET.genreCode                   -> Id3v1KnownGenres.DUET
      Id3v1KnownGenres.PUNK_ROCK.genreCode              -> Id3v1KnownGenres.PUNK_ROCK
      Id3v1KnownGenres.DRUM_SOLO.genreCode              -> Id3v1KnownGenres.DRUM_SOLO
      Id3v1KnownGenres.A_CAPELLA.genreCode              -> Id3v1KnownGenres.A_CAPELLA
      Id3v1KnownGenres.EURO_HOUSE.genreCode             -> Id3v1KnownGenres.EURO_HOUSE
      Id3v1KnownGenres.DANCE_HALL.genreCode             -> Id3v1KnownGenres.DANCE_HALL
      Id3v1KnownGenres.GOA_MUSIC.genreCode              -> Id3v1KnownGenres.GOA_MUSIC
      Id3v1KnownGenres.DRUM_AND_BASS.genreCode          -> Id3v1KnownGenres.DRUM_AND_BASS
      Id3v1KnownGenres.CLUB_HOUSE.genreCode             -> Id3v1KnownGenres.CLUB_HOUSE
      Id3v1KnownGenres.HARDCORE_TECHNO.genreCode        -> Id3v1KnownGenres.HARDCORE_TECHNO
      Id3v1KnownGenres.TERROR.genreCode                 -> Id3v1KnownGenres.TERROR
      Id3v1KnownGenres.INDIE.genreCode                  -> Id3v1KnownGenres.INDIE
      Id3v1KnownGenres.BRITPOP.genreCode                -> Id3v1KnownGenres.BRITPOP
      Id3v1KnownGenres.NEGERPUNK.genreCode              -> Id3v1KnownGenres.NEGERPUNK
      Id3v1KnownGenres.POLSK_PUNK.genreCode             -> Id3v1KnownGenres.POLSK_PUNK
      Id3v1KnownGenres.BEAT.genreCode                   -> Id3v1KnownGenres.BEAT
      Id3v1KnownGenres.CHRISTIAN_GANGSTA_RAP.genreCode  -> Id3v1KnownGenres.CHRISTIAN_GANGSTA_RAP
      Id3v1KnownGenres.HEAVY_METAL.genreCode            -> Id3v1KnownGenres.HEAVY_METAL
      Id3v1KnownGenres.BLACK_METAL.genreCode            -> Id3v1KnownGenres.BLACK_METAL
      Id3v1KnownGenres.CROSSOVER.genreCode              -> Id3v1KnownGenres.CROSSOVER
      Id3v1KnownGenres.CONTEMPORARY_CHRISTIAN.genreCode -> Id3v1KnownGenres.CONTEMPORARY_CHRISTIAN
      Id3v1KnownGenres.CHRISTIAN_ROCK.genreCode         -> Id3v1KnownGenres.CHRISTIAN_ROCK
      Id3v1KnownGenres.MERENGUE.genreCode               -> Id3v1KnownGenres.MERENGUE
      Id3v1KnownGenres.SALSA.genreCode                  -> Id3v1KnownGenres.SALSA
      Id3v1KnownGenres.TRASH_METAL.genreCode            -> Id3v1KnownGenres.TRASH_METAL
      Id3v1KnownGenres.ANIME.genreCode                  -> Id3v1KnownGenres.ANIME
      Id3v1KnownGenres.JPOP.genreCode                   -> Id3v1KnownGenres.JPOP
      Id3v1KnownGenres.SYNTHPOP.genreCode               -> Id3v1KnownGenres.SYNTHPOP
      Id3v1KnownGenres.ABSTRACT.genreCode               -> Id3v1KnownGenres.ABSTRACT
      Id3v1KnownGenres.ART_ROCK.genreCode               -> Id3v1KnownGenres.ART_ROCK
      Id3v1KnownGenres.BAROQUE.genreCode                -> Id3v1KnownGenres.BAROQUE
      Id3v1KnownGenres.BHANGRA.genreCode                -> Id3v1KnownGenres.BHANGRA
      Id3v1KnownGenres.BIG_BEAT.genreCode               -> Id3v1KnownGenres.BIG_BEAT
      Id3v1KnownGenres.BREAKBEAT.genreCode              -> Id3v1KnownGenres.BREAKBEAT
      Id3v1KnownGenres.CHILLOUT.genreCode               -> Id3v1KnownGenres.CHILLOUT
      Id3v1KnownGenres.DOWNTEMPO.genreCode              -> Id3v1KnownGenres.DOWNTEMPO
      Id3v1KnownGenres.DUB.genreCode                    -> Id3v1KnownGenres.DUB
      Id3v1KnownGenres.EBM.genreCode                    -> Id3v1KnownGenres.EBM
      Id3v1KnownGenres.ECLECTIC.genreCode               -> Id3v1KnownGenres.ECLECTIC
      Id3v1KnownGenres.ELECTRO.genreCode                -> Id3v1KnownGenres.ELECTRO
      Id3v1KnownGenres.ELECTROCLASH.genreCode           -> Id3v1KnownGenres.ELECTROCLASH
      Id3v1KnownGenres.EMO.genreCode                    -> Id3v1KnownGenres.EMO
      Id3v1KnownGenres.EXPERIMENTAL.genreCode           -> Id3v1KnownGenres.EXPERIMENTAL
      Id3v1KnownGenres.GARAGE.genreCode                 -> Id3v1KnownGenres.GARAGE
      Id3v1KnownGenres.GLOBAL.genreCode                 -> Id3v1KnownGenres.GLOBAL
      Id3v1KnownGenres.IDM.genreCode                    -> Id3v1KnownGenres.IDM
      Id3v1KnownGenres.ILLBIENT.genreCode               -> Id3v1KnownGenres.ILLBIENT
      Id3v1KnownGenres.INDUSTRO_GOTH.genreCode          -> Id3v1KnownGenres.INDUSTRO_GOTH
      Id3v1KnownGenres.JAM_BAND.genreCode               -> Id3v1KnownGenres.JAM_BAND
      Id3v1KnownGenres.KRAUTROCK.genreCode              -> Id3v1KnownGenres.KRAUTROCK
      Id3v1KnownGenres.LEFTFIELD.genreCode              -> Id3v1KnownGenres.LEFTFIELD
      Id3v1KnownGenres.LOUNGE.genreCode                 -> Id3v1KnownGenres.LOUNGE
      Id3v1KnownGenres.MATH_ROCK.genreCode              -> Id3v1KnownGenres.MATH_ROCK
      Id3v1KnownGenres.NEW_ROMANTIC.genreCode           -> Id3v1KnownGenres.NEW_ROMANTIC
      Id3v1KnownGenres.NU_BREAKZ.genreCode              -> Id3v1KnownGenres.NU_BREAKZ
      Id3v1KnownGenres.POST_PUNK.genreCode              -> Id3v1KnownGenres.POST_PUNK
      Id3v1KnownGenres.POST_ROCK.genreCode              -> Id3v1KnownGenres.POST_ROCK
      Id3v1KnownGenres.PSYTRANCE.genreCode              -> Id3v1KnownGenres.PSYTRANCE
      Id3v1KnownGenres.SHOEGAZE.genreCode               -> Id3v1KnownGenres.SHOEGAZE
      Id3v1KnownGenres.SPACE_ROCK.genreCode             -> Id3v1KnownGenres.SPACE_ROCK
      Id3v1KnownGenres.TROP_ROCK.genreCode              -> Id3v1KnownGenres.TROP_ROCK
      Id3v1KnownGenres.WORLD_MUSIC.genreCode            -> Id3v1KnownGenres.WORLD_MUSIC
      Id3v1KnownGenres.NEOCLASSICAL.genreCode           -> Id3v1KnownGenres.NEOCLASSICAL
      Id3v1KnownGenres.AUDIOBOOK.genreCode              -> Id3v1KnownGenres.AUDIOBOOK
      Id3v1KnownGenres.AUDIO_THEATRE.genreCode          -> Id3v1KnownGenres.AUDIO_THEATRE
      Id3v1KnownGenres.NEUE_DEUTSCHE_WELLE.genreCode    -> Id3v1KnownGenres.NEUE_DEUTSCHE_WELLE
      Id3v1KnownGenres.PODCAST.genreCode                -> Id3v1KnownGenres.PODCAST
      Id3v1KnownGenres.INDIE_ROCK.genreCode             -> Id3v1KnownGenres.INDIE_ROCK
      Id3v1KnownGenres.G_FUNK.genreCode                 -> Id3v1KnownGenres.G_FUNK
      Id3v1KnownGenres.DUBSTEP.genreCode                -> Id3v1KnownGenres.DUBSTEP
      Id3v1KnownGenres.GARAGE_ROCK.genreCode            -> Id3v1KnownGenres.GARAGE_ROCK
      Id3v1KnownGenres.PSYBIANT.genreCode               -> Id3v1KnownGenres.PSYBIANT
      else                                              -> Id3v1KnownGenres.UNKNOWN
    }
}

enum class Id3v1KnownGenres(
  val genreCode: Int,
  val genre: String
)
{
  UNKNOWN(255, "UNKNOWN"),

  BLUES(0, "Blues"),
  CLASSIC_ROCK(1, "Classic Rock"),
  COUNTRY(2, "Country"),
  DANCE(3, "Dance"),
  DISCO(4, "Disco"),
  FUNK(5, "Funk"),
  GRUNGE(6, "Grunge"),
  HIP_HOP(7, "Hip-Hop"),
  JAZZ(8, "Jazz"),
  METAL(9, "Metal"),
  NEW_AGE(10, "New Age"),
  OLDIES(11, "Oldies"),
  OTHER(12, "Other"),
  POP(13, "Pop"),
  RHYTHM_AND_BLUES(14, "Rhythm and Blues"),
  RAP(15, "Rap"),
  REGGAE(16, "Reggae"),
  ROCK(17, "Rock"),
  TECHNO(18, "Techno"),
  INDUSTRIAL(19, "Industrial"),
  ALTERNATIVE(20, "Alternative"),
  SKA(21, "Ska"),
  DEATH_METAL(22, "Death Metal"),
  PRANKS(23, "Pranks"),
  SOUNDTRACK(24, "Soundtrack"),
  EURO_TECHNO(25, "Euro-Techno"),
  AMBIENT(26, "Ambient"),
  TRIP_HOP(27, "Trip-Hop"),
  VOCAL(28, "Vocal"),
  JAZZ_AND_FUNK(29, "Jazz & Funk"),
  FUSION(30, "Fusion"),
  TRANCE(31, "Trance"),
  CLASSICAL(32, "Classical"),
  INSTRUMENTAL(33, "Instrumental"),
  ACID(34, "Acid"),
  HOUSE(35, "House"),
  GAME(36, "Game"),
  SOUND_CLIP(37, "Sound clip"),
  GOSPEL(38, "Gospel"),
  NOISE(39, "Noise"),
  ALTERNATIVE_ROCK(40, "Alternative Rock"),
  BASS(41, "Bass"),
  SOUL(42, "Soul"),
  PUNK(43, "Punk"),
  SPACE(44, "Space"),
  MEDITATIVE(45, "Meditative"),
  INSTRUMENTAL_POP(46, "Instrumental Pop"),
  INSTRUMENTAL_ROCK(47, "Instrumental Rock"),
  ETHNIC(48, "Ethnic"),
  GOTHIC(49, "Gothic"),
  DARKWAVE(50, "Darkwave"),
  TECHNO_INDUSTRIAL(51, "Techno-Industrial"),
  ELECTRONIC(52, "Electronic"),
  POP_FOLK(53, "Pop-Folk"),
  EURODANCE(54, "Eurodance"),
  DREAM(55, "Dream"),
  SOUTHERN_ROCK(56, "Southern Rock"),
  COMEDY(57, "Comedy"),
  CULT(58, "Cult"),
  GANGSTA(59, "Gangsta"),
  TOP_40(60, "Top 40"),
  CHRISTIAN_RAP(61, "Christian Rap"),
  POP_FUNK(62, "Pop/Funk"),
  JUNGLE_MUSIC(63, "Jungle music"),
  NATIVE_US(64, "Native US"),
  CABARET(65, "Cabaret"),
  NEW_WAVE(66, "New Wave"),
  PSYCHEDELIC(67, "Psychedelic"),
  RAVE(68, "Rave"),
  SHOWTUNES(69, "Showtunes"),
  TRAILER(70, "Trailer"),
  LO_FI(71, "Lo-Fi"),
  TRIBAL(72, "Tribal"),
  ACID_PUNK(73, "Acid Punk"),
  ACID_JAZZ(74, "Acid Jazz"),
  POLKA(75, "Polka"),
  RETRO(76, "Retro"),
  MUSICAL(77, "Musical"),
  ROCK_N_ROLL(78, "Rock ’n’ Roll"),
  HARD_ROCK(79, "Hard Rock"),

  // Winamp Extension
  FOLK(80, "Folk"),
  FOLK_ROCK(81, "Folk-Rock"),
  NATIONAL_FOLK(82, "National Folk"),
  SWING(83, "Swing"),
  FAST_FUSION(84, "Fast Fusion"),
  BEBOP(85, "Bebop"),
  LATIN(86, "Latin"),
  REVIVAL(87, "Revival"),
  CELTIC(88, "Celtic"),
  BLUEGRASS(89, "Bluegrass"),
  AVANTGARDE(90, "Avantgarde"),
  GOTHIC_ROCK(91, "Gothic Rock"),
  PROGRESSIVE_ROCK(92, "Progressive Rock"),
  PSYCHEDELIC_ROCK(93, "Psychedelic Rock"),
  SYMPHONIC_ROCK(94, "Symphonic Rock"),
  SLOW_ROCK(95, "Slow Rock"),
  BIG_BAND(96, "Big Band"),
  CHORUS(97, "Chorus"),
  EASY_LISTENING(98, "Easy Listening"),
  ACOUSTIC(99, "Acoustic"),
  HUMOUR(100, "Humour"),
  SPEECH(101, "Speech"),
  CHANSON(102, "Chanson"),
  OPERA(103, "Opera"),
  CHAMBER_MUSIC(104, "Chamber Music"),
  SONATA(105, "Sonata"),
  SYMPHONY(106, "Symphony"),
  BOOTY_BASS(107, "Booty Bass"),
  PRIMUS(108, "Primus"),
  PORN_GROOVE(109, "Porn Groove"),
  SATIRE(110, "Satire"),
  SLOW_JAM(111, "Slow Jam"),
  CLUB(112, "Club"),
  TANGO(113, "Tango"),
  SAMBA(114, "Samba"),
  FOLKLORE(115, "Folklore"),
  BALLAD(116, "Ballad"),
  POWER_BALLAD(117, "Power Ballad"),
  RHYTHMIC_SOUL(118, "Rhythmic Soul"),
  FREESTYLE(119, "Freestyle"),
  DUET(120, "Duet"),
  PUNK_ROCK(121, "Punk Rock"),
  DRUM_SOLO(122, "Drum Solo"),
  A_CAPELLA(123, "A cappella"),
  EURO_HOUSE(124, "Euro-House"),
  DANCE_HALL(125, "Dance Hall"),
  GOA_MUSIC(126, "Goa music"),
  DRUM_AND_BASS(127, "Drum & Bass"),
  CLUB_HOUSE(128, "Club-House"),
  HARDCORE_TECHNO(129, "Hardcore Techno"),
  TERROR(130, "Terror"),
  INDIE(131, "Indie"),
  BRITPOP(132, "BritPop"),
  NEGERPUNK(133, "Negerpunk"),
  POLSK_PUNK(134, "Polsk Punk"),
  BEAT(135, "Beat"),
  CHRISTIAN_GANGSTA_RAP(136, "Christian Gangsta Rap"),
  HEAVY_METAL(137, "Heavy Metal"),
  BLACK_METAL(138, "Black Metal"),
  CROSSOVER(139, "Crossover"),
  CONTEMPORARY_CHRISTIAN(140, "Contemporary Christian"),
  CHRISTIAN_ROCK(141, "Christian Rock"),

  // Winamp 1.91
  MERENGUE(142, "Merengue"),
  SALSA(143, "Salsa"),
  TRASH_METAL(144, "Thrash Metal"),
  ANIME(145, "Anime"),
  JPOP(146, "Jpop"),
  SYNTHPOP(147, "Synthpop"),

  // Winamp 5.6
  ABSTRACT(148, "Abstract"),
  ART_ROCK(149, "Art Rock"),
  BAROQUE(150, "Baroque"),
  BHANGRA(151, "Bhangra"),
  BIG_BEAT(152, "Big beat"),
  BREAKBEAT(153, "Breakbeat"),
  CHILLOUT(154, "Chillout"),
  DOWNTEMPO(155, "Downtempo"),
  DUB(156, "Dub"),
  EBM(157, "EBM"),
  ECLECTIC(158, "Eclectic"),
  ELECTRO(159, "Electro"),
  ELECTROCLASH(160, "Electroclash"),
  EMO(161, "Emo"),
  EXPERIMENTAL(162, "Experimental"),
  GARAGE(163, "Garage"),
  GLOBAL(164, "Global"),
  IDM(165, "IDM"),
  ILLBIENT(166, "Illbient"),
  INDUSTRO_GOTH(167, "Industro-Goth"),
  JAM_BAND(168, "Jam Band"),
  KRAUTROCK(169, "Krautrock"),
  LEFTFIELD(170, "Leftfield"),
  LOUNGE(171, "Lounge"),
  MATH_ROCK(172, "Math Rock"),
  NEW_ROMANTIC(173, "New Romantic"),
  NU_BREAKZ(174, "Nu-Breakz"),
  POST_PUNK(175, "Post-Punk"),
  POST_ROCK(176, "Post-Rock"),
  PSYTRANCE(177, "Psytrance"),
  SHOEGAZE(178, "Shoegaze"),
  SPACE_ROCK(179, "Space Rock"),
  TROP_ROCK(180, "Trop Rock"),
  WORLD_MUSIC(181, "World Music"),
  NEOCLASSICAL(182, "Neoclassical"),
  AUDIOBOOK(183, "Audiobook"),
  AUDIO_THEATRE(184, "Audio Theatre"),
  NEUE_DEUTSCHE_WELLE(185, "Neue Deutsche Welle"),
  PODCAST(186, "Podcast"),
  INDIE_ROCK(187, "Indie-Rock"),
  G_FUNK(188, "G-Funk"),
  DUBSTEP(189, "Dubstep"),
  GARAGE_ROCK(190, "Garage Rock"),
  PSYBIANT(191, "Psybient")
}
