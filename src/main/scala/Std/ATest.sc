(x: Int) => x + 1

var increase = (x: Int) => x + 1

var i = 0

 i = increase(10)

var increase100 = (x: Int) => x + 100

increase100(10)

val someNumbers = List(-11,	-10,	-5,	0,	5, 10, 11, 20)

someNumbers.foreach(increase)

someNumbers.filter(_ > 0)

val f = (_: Int) + (_: Int)
f(20, 80)

@scala.annotation.tailrec
def loop(x: Int, acc: Int = 1): Int = {
 if (x <= 1) acc
 else loop(x - 1, x * acc)
}

loop(10)

def factorial(n: Int): Int = {
 if (n == 0)
  1
 else
  n * factorial(n-1)
}

factorial(10)
