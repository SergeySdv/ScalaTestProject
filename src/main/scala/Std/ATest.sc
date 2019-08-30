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