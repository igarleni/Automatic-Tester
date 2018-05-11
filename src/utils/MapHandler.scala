package utils

object MapHandler {
  
  def get(map: Map[String, String], key: String): String =
  {
    val found = map.get(key)
    return found match
    {
      case Some(value) => value
      case _ => throw new Exception("Item not Found in map!")
    }
  }
}