package factories

import persistence._
import launchers._
import IO._
import scala.collection.mutable.Map

object TestFactory 
{
  def generateTests(testsPath: String, appLauncher: Launcher): List[Test] =
  {
    val inputFiles = ConfigurationReader.readTestsConfiguration(testsPath)
    val testList = mergeByTestID(inputFiles)
    for(test <- testList) test.validate()
    testList
  }
  
  private def mergeByTestID(inputFiles: List[InputFile]): List[Test] =
  {
    return null
  }
  
}