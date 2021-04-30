package fr.amoya.ktaglib.file


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


expect object FileReaderFactory
{
  fun createFileReader(fileName: String): FileReader
}
