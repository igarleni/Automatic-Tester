package IO

import persistence._
import utils._
import java.io.File

object FileSystemUtils 
{
  def backupFiles(appPaths: MapHandler)
  {
    
  }
  
  def saveSummaries(summaries: List[Summary], testsPath: String)
  {
    
  }
  
  def createTestFolders(modelsBatteryPath: String, test: Test)
  {
    
  }
  
  def getListOfFiles(path: String):List[File] =
  {
    val file = new File(path)
    if (file.exists && file.isDirectory)
    {
      file.listFiles.filter(_.isFile).toList
    } else 
    {
        Nil
    }
  }
}