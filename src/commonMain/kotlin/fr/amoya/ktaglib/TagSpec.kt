package fr.amoya.ktaglib


/*
* fr.amoya.ktaglib
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/

/**
 * The "Magic Number" is a Hex representation of the tag inside the file
 */
enum class TagSpec(val magicNumber: Long)
{
  NONE(0),
  ID3V1(0x54_41_47),              // "TAG"
  ID3V22(0x49_44_33_02),          // "ID3" + 0x02
  ID3V23(0x49_44_33_03),          // "ID3" + 0x03
  ID3V24(0x49_44_33_04),          // "ID3" + 0x04
  FLAC(0x66_4c_61_43),            // "fLaC"
  RIFF(0x52_49_46_46),            // "RIFF"
  OGG(0x4f_67_67_53),             // "OggS"
  APE(0x41_50_45_54_41_47_45_58)  // "APETAGEX"
}
