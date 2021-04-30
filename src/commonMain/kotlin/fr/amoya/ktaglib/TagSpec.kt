package fr.amoya.ktaglib


/*
* fr.amoya.ktaglib
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


enum class TagSpec(val magicNumber: Long)
{
  NONE(0),
  ID3V1(0x54_41_47),
  ID3V22(0x49_44_33_02),
  ID3V23(0x49_44_33_03),
  ID3V24(0x49_44_33_04),
  FLAC(0x66_4c_61_43),
  RIFF(0x52_49_46_46),
  OGG(0x4f_67_67_53),
  APE(0x41_50_45_54_41_47_45_58)
}
