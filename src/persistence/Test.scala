package persistence

import launchers._

trait Test {
  val testID: Int
  def runTest(): Summary
  def validate()
  //TODO ordenable or ID para List.head
}