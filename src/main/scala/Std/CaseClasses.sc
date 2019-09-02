abstract class Term
case class Var(name: String) extends Term
case class Fun(arg: String, body: Term) extends Term
case class App(f: Term, v: Term) extends Term

object TermTest  {
  def printTerm(term: Term) {
    term match {
      case Var(n) =>
        print(n)
      case Fun(x, b) =>
        print("^" + x + ".")
        printTerm(b)
      case App(f, v) =>
        print("(")
        printTerm(f)
        print(" ")
        printTerm(v)
        print(")")
    }
  }
  def isIdentityFun(term: Term): Boolean = term match {
    case Fun(x, Var(y)) if x == y => true
    case _ => false
  }
  val id = Fun("x", Var("x"))
  val t = Fun("x", Fun("y", App(Var("x"), Var("y"))))
  printTerm(t)
  println
  println(isIdentityFun(id))
  println(isIdentityFun(t))
}

//Case classes have an automatic hashcode method that works:

case class Person(first: String, last: String)

val p1 = new Person("Fred", "Jones")
val p2 = new Person("Shaggy", "Rigers")
val p3 = new Person("Fred", "Jones")

p1.hashCode() == p2.hashCode()
p1.hashCode() == p3.hashCode()

p1.equals(p3)

//Case classes can be created in a convenient way:

case class Dog(name: String, breed: String)

val d1 = Dog("Scooby", "Doberman")
val d2 = Dog("Rex", "Custom")

val d3 = new Dog("Scooby", "Doberman")  // the old way
                                                            // of creating
                                                            // using new
d1 == d3
d1 == d2
d2 == d3

// Case classes have a convenient toString methods defined"

case class Dog4(name: String, breed: String)
val d4 = Dog4("Scooby", "Doberman")
d4.toString

// Case classes have automatic properties:

case class Dog5(name: String, breed: String)
val d5 = Dog5("Scooby", "Doberman")
d1.name
d1.breed

//Case classes can have mutable properties:

case class Dog6(var name: String, breed: String) // you can rename a dog,
                                                  // but change its breed?
val d6 = Dog6("Scooby", "Doberman")

d6.name
d6.breed

d6.name = "Scooby Doo" // but is it a good idea?

d6.name
d6.breed

//  Thera are safer alternatives for alternating case classees:

case class Dog7(name: String, breed: String)

val d71 = Dog7("Scooby", "Doberman")

val d72 = d71.copy(name = "Scooby Doo") // copy the case class but change
                                              // in the copy
d71.name
d71.breed

d72.name
d72.breed

// Clase classes can have default and named parameters:

case class Person8(first: String, last: String, age: Int = 0, ssn: String = "")
val p81 = Person8("Fred", "Jones", 23, "111-22-3333")
val p82 = Person8("Samanta", "Jones") // missing age and ssn
val p83 = Person8(last = "Jones", first = "Fred", ssn = "111-22-3333")
                                                        // the order can change,
                                                        // and missing age
val p84 = p83.copy(age = 23)
p81.first
p81.last
p81.age
p81.ssn

p82.first
p82.last
p82.age
p82.ssn

p83.first
p83.last
p83.age
p83.ssn

p81 == p84

// Case classes can be disassembled to their constituent parts as a tuple:

case class Person9(first: String, last: String, age: Int = 0, ssn: String = "")
val p91 = Person9("Fred", "Jones", 23, "111-22-3333")
val parts = Person9.unapply(p91).get //seems weird,
                                                                // but it's
                                      //  critical to other features of Scala
parts._1
parts._2
parts._3
parts._4

// Case classes are Serializeble:

case class PersonCC(firstName: String, lastName: String)
val indy = PersonCC("Indiana", "Jones")

indy.isInstanceOf[Serializable]

class Person10(firstName: String, lastName: String)
val junior = new Person10("Indiana", "Jones")

junior.isInstanceOf[Serializable]
