//A repeated parameter must be the last parameter and this will let you add as many extra parameters as needed.

def repeatedParameterMethod(x: Int, y: String, z: Any*) = {
  "%d %ss can give you %s".format(x, y, z.mkString(", "))
}

//A repeated parameter can accept a collection as the last parameter but will be considered a single object:

repeatedParameterMethod(3, "egg", List("a delicious sandwich", "protein", "high cholesterol"))

//A repeated parameter can accept a collection - if you want it expanded, add :_*
repeatedParameterMethod(
  3,
  "egg",
  List("a delicious sandwich", "protein", "high cholesterol"): _*)