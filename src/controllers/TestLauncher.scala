package controllers

import persistence._
import launchers._
import IO._
import utils._

object TestLauncher 
{
  def launchTests(tests: List[Test]): List[Summary] = 
  {
    val test = tests.head
    val summary = test.runTest()
    val testsTail = tests.tail
    if (testsTail != Nil)
      return List(summary)
    else
      return summary :: launchTests(testsTail)
  }
}