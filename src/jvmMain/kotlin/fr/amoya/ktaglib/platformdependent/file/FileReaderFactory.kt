package fr.amoya.ktaglib.platformdependent.file

import fr.amoya.ktaglib.platformdependent.file.FileReader
import kotlin.io.path.ExperimentalPathApi


/*
* fr.amoya.ktaglib.file
* As a part of the Project k-taglib
* @Author Arnaud Moya : <contact@amoya.fr>
* Created on 30/04/2021
*/


actual object FileReaderFactory
{
  actual fun loadFileReader(fileName: String): FileReader = JvmFileReader().apply { load(fileName) }
}
