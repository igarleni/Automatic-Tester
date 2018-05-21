package launchers

import persistence._

trait Launcher 
{
  val scriptPath: String
  val appRoot: String
  def runApp()
}

object Launcher
{
  def apply(launcherType: String, appRoot: String, scriptPath: String) : Launcher = 
  {
    launcherType match
    {
      case "R" => new RLauncher(appRoot, appRoot + scriptPath)
      case "SH" => new SHLauncher(appRoot, appRoot + scriptPath)
      case _ => throw new Exception("Not valid Launcher Type")
    }
  }
}