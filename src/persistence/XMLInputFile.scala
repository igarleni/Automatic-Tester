package persistence

class XMLInputFile (val testID: Int, header: Array[String],
    rowData: Array[String]) extends InputFile
{
  val xmlData = generateXML(header, rowData)
  //TODO crear testConfigFile, además de los inputs que hay aquí
}