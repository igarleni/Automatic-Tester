
import org.ddahl.rscala._

object Tester extends App{
  println("hello world!")
  scala.io.StdIn.readLine()
  val rConnection = RClient()
  rConnection.eval("source('HelloWorld.R')")
}
