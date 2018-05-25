
package controllers

import launchers._
import IO._
import factories._
import utils._

object Tester 
{
  def main(args: Array[String]): Unit =
  {
    try
    {
      printHelloMessage()
    	val (projectRoot, launcherRelativePath, 
			launcherType, testsPath) = readInputArgs(args)
			val appLauncher = Launcher(launcherType, projectRoot, launcherRelativePath)
			val tests = TestFactory.generateTests(testsPath, appLauncher)
			val summaries = TestLauncher.launchTests(tests)
			FileSystemUtils.saveSummaries(summaries, testsPath)
    }
    catch
    {
      case e => 
        {
          println("\nERROR: " + e.getMessage)
          val stackTrace = e.getStackTrace
          println("\nSTACKTRACE:")
          stackTrace.foreach(println(_))
        }
    }
  }
  
  private def readInputArgs(args:Array[String]) = 
  {
    val total = args.length - 1
    val parseOption:(String => String) = option =>
    ({
      val pos = args.indexOf(option)
      if (pos != -1 && pos < total)
        args(pos +1)
      else
        throw new Exception("Missing " + option)
    })
    val projectRoot = parseOption("-PROJECT_ROOT")
    val launcherRelativePath = parseOption("-APP_LAUNCHER_PATH_RELATIVE")
    val launcherType = parseOption("-LAUNCHER_TYPE")
    val testsPath = parseOption("-TESTS_PATH")
    (projectRoot, launcherRelativePath, launcherType, testsPath)
  }
  
  private def generateAppPaths(projectRoot: String, testsPath: String):
      MapHandler =
  {
    val modelsBatteryPath = (testsPath + "testsResults/")
    val configPath = (projectRoot + "config/")
    val outputPath = (projectRoot + "output/")
    val logsPath = (projectRoot + "logs/")
    val map = Map("modelsBatteryPath" -> modelsBatteryPath, 
        "configPath" -> configPath, "outputPath" -> outputPath,
        "logsPath" -> logsPath)
    
    new MapHandler(map)
  }
  
  private def printHelloMessage()
  {
    println("########################################################################")
    println("####  ______   ______     ______     ______   ______     ______     ####")
    println("##   /\\__  _\\ /\\  ___\\   /\\  ___\\   /\\__  _\\ /\\  ___\\   /\\  == \\      ##")
    println("##   \\/_/\\ \\/ \\ \\  __\\   \\ \\___  \\  \\/_/\\ \\/ \\ \\  __\\   \\ \\  __<      ##")
    println("##      \\ \\_\\  \\ \\_____\\  \\/\\_____\\    \\ \\_\\  \\ \\_____\\  \\ \\_\\ \\_\\    ##")
    println("##       \\/_/   \\/_____/   \\/_____/     \\/_/   \\/_____/   \\/_/ /_/    ##")
    println("####                                                                ####")
    println("########################################################################")
    println("####                                                                ####")
    println("## Author: Italo Garleni Rodriguez                                    ##")
    println("## Bug report: https://github.com/italogar6/Automatic-Tester/issues   ##")
    println("####                                                                ####")
    println("########################################################################")
  }
  
}
