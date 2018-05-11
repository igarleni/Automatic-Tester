package launchers

trait Launcher {
  val scriptPath: String
  
  def launchApp
}