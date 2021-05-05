package fr.amoya.ktaglib.platformdependent.file


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


expect object FileReaderFactory
{
  /**
   * creates in instance of FileReader then load the file
   * should call the load method internally when implemented
   */
  fun loadFileReader(fileName: String): FileReader
}
