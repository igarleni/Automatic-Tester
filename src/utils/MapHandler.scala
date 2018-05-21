package utils

class MapHandler (map: Map[String,String]) {
  
  def get(key: String): String =
  {
    val found = map.get(key)
    
    return found match
    {
      case Some(value) => value.toString
      case _ => throw new Exception("Item not Found in map!")
    }
  }
}