package launchers

import org.ddahl.rscala._

class RLauncher (val scriptPath:String) extends Launcher
{
  override def launchApp()
  {
		  val rConnection = RClient()
		  rConnection.eval("source('" + scriptPath + "')")
  }
}