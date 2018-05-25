package IO

import java.io.File
import persistence._

object ConfigurationReader
{
  
  def readTestsConfiguration(testsPath: String): List[InputFile] =
  {
    val fileList = FileSystemUtils.getListOfFiles(testsPath)
    val parsedFiles = readConfigFiles(fileList)
    if(parsedFiles == Nil) throw new Exception("No config files found!")
    parsedFiles
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
  
  private def readFile(file: File): List[InputFile] =
  {
    val filePath = file.getAbsolutePath.toLowerCase
    filePath match
    {
      case path if path.endsWith(".csv") => Parsers.parseCSV(file)
      case _ => Nil
    }
  }
  
}