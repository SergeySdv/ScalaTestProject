//for expressions can nest, with later generators varying more rapidly
// than earlier ones:

val xValues = 1 to 4
val yValues = 1 to 2
val coordinates = for {
  x <- xValues
  y <- yValues
} yield (x, y)
coordinates(4)

//  Using for we can make more readable code:

val nums = List(List(1), List(2), List(3), List(4), List(5))

val result = for {
  numList <- nums
  num <- numList
  if (num % 2 == 0)
} yield (num)

result

// Which is the same as
nums.flatMap(numList => numList).filter(_ % 2 == 0)

// or the same as
nums.flatten.filter(_ % 2 == 0)

//Infix operators do NOT work if an object has a method that takes two parameters:

val g: String = "Check out the big brains on Brad!"

g indexOf 'o'
//indexOf(Char) can be used as an infix operator

// g indexOf 'o', 4 should be (6) //indexOf(Char, Int)
// cannot be used as an infix operator

g.indexOf('o', 7)

val gs: Int = 31
(gs toHexString)

//  Here's how to create a prefix operator for our own class.
//  The only identifiers that can be used as prefix operators are +, -, !, and ~:

class Stereo {
  def unary_+ = "on"

  def unary_- = "off"
}

val stereo = new Stereo
(+stereo)
(-stereo)