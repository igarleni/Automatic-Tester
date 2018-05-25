package IO

import persistence._
import java.io.File
import io.Source.fromFile
import io.BufferedSource
import scala.collection.mutable.ArrayBuffer

object Parsers {
  
  def parseCSV(file: File, delimiter: String = ";"): 
      List[InputFile] =
  {
    val bufferedSource = fromFile(file.getAbsolutePath)
    val fileName = file.getName
    val fileList = ArrayBuffer[InputFile]()
    val iterator = bufferedSource.getLines()
    val header = iterator.next().split(delimiter).map(_.trim).toList
  	for (line <- iterator) 
  	{
  		val rowData = line.split(delimiter).map(_.trim).toList
  		val inputFile = InputFile(fileName, rowData, header)
			fileList.append(inputFile)
  	}
  	bufferedSource.close
    
    fileList.toList
  }
  
}