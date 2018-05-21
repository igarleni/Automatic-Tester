package launchers

import org.ddahl.rscala._
import persistence._

class RLauncher (val appRoot:String, val scriptPath:String) extends Launcher
{
  val configFolder: String = appRoot + "config/"
  val logFolder: String = appRoot + "logs/"
  val outputFolder: String = appRoot + "output/"
  
  override def runApp()
  {
		  val rConnection = RClient()
		  rConnection.eval("source('" + scriptPath + "')")
  }
  
}