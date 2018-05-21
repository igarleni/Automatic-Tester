package IO

import io.Source.fromFile
import io.BufferedSource
import scala.collection.mutable.ArrayBuffer
import scala.util.matching.Regex
import scala.util.matching
import java.io.File

import persistence._

object ConfigurationReader
{
  
  def readTestsConfiguration(testsPath: String): List[InputFile] =
  {
    val fileList = FileSystemUtils.getListOfFiles(testsPath)
    readConfigFiles(fileList)
  }
  
  private def readConfigFiles(fileList: List[File]): 
    List[InputFile] =
  {
    fileList match
    {
      case Nil => Nil
      case headFile::Nil => readFile(headFile)
      case headFile::tailFiles => readFile(headFile):::readConfigFiles(tailFiles)
    }
  }
  
  private def parseCSV(path: String, delimiter: String = ";"): 
      List[InputFile] =
  {
    val bufferedSource = fromFile(path)
    val fileList = ArrayBuffer[InputFile]()
    try
    {
      val iterator = bufferedSource.getLines()
      val header = iterator.next().split(delimiter).map(_.trim)
    	for (line <- iterator) 
    	{
    		val rowData = line.split(delimiter).map(_.trim)
    		val inputFile = InputFile(rowData, header)
				fileList.append(inputFile)
    	}
    }
    catch
    {
      case e:Exception => throw new Exception("File "+ path + " not found!")
    }
    finally
    {
    	bufferedSource.close
    }
    
    fileList.toList
  }
  
  private def readFile(file: File): List[InputFile] =
  {
    val filePath = file.getAbsolutePath.toLowerCase
    filePath match
    {
      case path if path.endsWith(".csv") => parseCSV(path)
      case _ => Nil
    }
  }
  
}