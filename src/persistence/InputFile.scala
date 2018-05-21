package persistence

trait InputFile
{
  val testID: Int
}

object InputFile
{
  def apply(rowData: Array[String], header: Array[String]) : InputFile = 
  {
    val testID = getTestID(header, rowData)
    new XMLInputFile(testID, header, rowData)
  }
  
  private def getTestID(rowData: Array[String], header: Array[String]): Int =
  {
    
  }
}