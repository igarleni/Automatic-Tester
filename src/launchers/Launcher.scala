package launchers

trait Launcher 
{
  val scriptPath: String
  
  def launchApp
}

object Launcher
{
  def apply(launcherType: String, launcherPath: String) : Launcher = 
  {
    launcherType match
    {
      case "R" => new RLauncher(launcherPath)
      case "SH" => new SHLauncher(launcherPath)
    }
  }
}