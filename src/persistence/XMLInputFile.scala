package persistence

import scala.xml._

class XMLInputFile (val testID: Int, val fileName: String,
    branches: List[String], data: List[String]) extends InputFile
{
  val xmlData: Elem = generateXML(branches, data)
  
  private def generateXML(branches: List[String], data: List[String]):
      Elem =
  {
    val nBranches = branches.length
    if (nBranches != data.length) 
      throw new Exception("branches and data have different size.")
    val rootNode = Elem(null, fileName, Null, TopScope, false,
        generateChilds(branches, data))
    
    rootNode
  }
  
  private def generateChilds(branch: List[String], data: List[String]):
      List[Elem] =
  {
    //TODO seguir aqui
    return null
  }
  
}