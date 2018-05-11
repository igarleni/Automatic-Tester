package launchers

import org.ddahl.rscala._

class SHLauncher (val scriptPath:String) extends Launcher{
  
  override def launchApp()
  {
		  val rConnection = RClient()
		  rConnection.eval("source('" + scriptPath + "')")
  }

}