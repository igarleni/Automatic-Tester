
package executors

import org.ddahl.rscala._

object Tester 
{
  def main(args: Array[String]): Unit =
  {
    val (projectRoot, launcherRelativePath, 
        launcherType, testsPath) = readInputArgs(args)
  }
  
  private def readInputArgs(args:Array[String]) = 
  {
    val total = args.length -1
    val projectRoot = parseOption(args, total, "-PROJECT_ROOT")
    val launcherRelativePath = parseOption(args, total, "-APP_LAUNCHER_PATH_RELATIVE")
    val launcherType = parseOption(args, total, "-LAUNCHER_TYPE")
    val testsPath = parseOption(args, total, "-TESTS_PATH")
    
    (projectRoot, launcherRelativePath, launcherType, testsPath)
  }
  
  private def parseOption(args: Array[String], total: Int, option: String):
    String =
  {
    for (i <- 0 until total if args(i).equals(option))
        return(args(i+1))
        
		throw new Exception("Missing " + option)
  }
  
}
