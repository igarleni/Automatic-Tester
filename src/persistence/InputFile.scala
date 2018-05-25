package persistence

trait InputFile
{
  val testID: Int
  val fileName: String
}

object InputFile
{
  def apply(fileName: String, rowData: List[String], header: List[String]): 
      InputFile = 
  {
    val testIDindex = getTestIDIndex(fileName, header, rowData)
    //TODO añadir caso de testConfigFile, además de los inputs que hay aquí
    new XMLInputFile(rowData(testIDindex).toInt, fileName,
        header.drop(testIDindex),
        rowData.drop(testIDindex))
  }
  
  private def getTestIDIndex(fileName: String, rowData: List[String], 
      header: List[String]): Int =
  {
    val testIDindex = header.indexOf((x:String) => x == "X.TestID")
    if(testIDindex == -1) 
      throw new Exception(fileName + ": X.TestID not found!")
    return(testIDindex)
  }
  
}