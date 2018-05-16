
package executors

import launchers._
import IO._
import factories._

object Tester 
{
  def main(args: Array[String]): Unit =
  {
    val (projectRoot, launcherRelativePath, 
        launcherType, testsPath) = readInputArgs(args)
    val appPaths = generateAppPaths(projectRoot, testsPath)
    val appLauncher:Launcher = Launcher(launcherType,
        projectRoot + launcherRelativePath)
    FileSystemGestor.backupFiles(appPaths)
    
    val tests = TestFactory.generateTests(testsPath)
    val summaries = TestLauncher.launchTests(tests)
    FileSystemGestor.saveSummaries(summaries, testsPath)
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
      Map[String, String] =
  {
    return null //TODO
  }
  
}
