import scala.annotation.tailrec

def abs(x:Double) = if (x < 0) -x else x

def sqrt(x: Double) {

  @tailrec
  def sqrtIter(guess: Double): Double = {
    if (isGoodEnough(guess)) guess
    else sqrtIter(improve(guess))
  }
  def isGoodEnough(guess: Double) = abs(guess * guess - x) / x < 0.001

  def improve(guess: Double) = (guess + x / guess) / 2

  sqrtIter(1.0)
  println(sqrt(2))

}

abs(-4)
println(sqrt(2))



