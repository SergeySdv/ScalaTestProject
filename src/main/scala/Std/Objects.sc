object GreetingHi {
  def english = "Hi"

  def espanol = "Hola"

}

GreetingHi.english

GreetingHi.espanol


object Greeting {
  def english = "Hi"

  def espanol = "Hola"
}

val x = Greeting
val y = x

x eq y

val z = Greeting

x eq z


class Movie(val name: String, val year: Short)

object Movie {
  def academyAwardBestMoviesForYear(x: Short) = {
    //This is a match statement, more powerful than a Java switch statement!
    x match {
      case 1930 => Some(new Movie("All Quiet On the Western Front", 1930))
      case 1931 => Some(new Movie("Cimarron", 1931))
      case 1932 => Some(new Movie("Grand Hotel", 1932))
      case _ => None
    }
  }
}

Movie.academyAwardBestMoviesForYear(1932).get.name



object Person {
  def showMeInnerSecret(x: Person) = x.superheroName
}

class Person(val name: String, private val superheroName: String) //The superhero name is private!

val clark = new Person("Clark Kent", "Superman")
val peter = new Person("Peter Parker", "Spider-Man")

Person.showMeInnerSecret(clark)
Person.showMeInnerSecret(peter)