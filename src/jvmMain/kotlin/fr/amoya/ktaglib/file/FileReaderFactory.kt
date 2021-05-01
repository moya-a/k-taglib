package fr.amoya.ktaglib.file


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


actual object FileReaderFactory
{
  actual fun createFileReader(fileName: String): FileReader = JvmFileReader().apply { load(fileName) }
}
