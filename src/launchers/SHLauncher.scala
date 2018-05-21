package launchers

import persistence._

class SHLauncher (val appRoot:String, val scriptPath:String) extends Launcher
{
  val configFolder: String = appRoot + "config/"
  val logFolder: String = appRoot + "logs/"
  val outputFolder: String = appRoot + "output/"
  
  override def runApp()
  {
  }
}