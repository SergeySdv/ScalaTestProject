//A partially applied function is a function
// that you do not apply any or all the arguments,
// creating another function. This partially
// applied function doesn't apply any arguments.

def sum(a: Int, b: Int, c: Int) = a + b + c
val sum3 = sum _
sum3(1, 9, 7)
sum(4, 5, 6)

//Partially applied functions can replace any
// number of arguments:

def sum2(a: Int, b: Int, c: Int) = a + b + c
val sumC = sum2(1, 10, _: Int)
sumC(4)
sum2(4, 5, 6)

//Currying is a technique to transform a function
// with multiple parameters into multiple functions
// which each take one parameter:

def multiply(x: Int, y: Int) = x * y
(multiply _).isInstanceOf[Function2[_, _, _]]
val multiplyCurried = (multiply _).curried
multiply(4, 5)
multiplyCurried(3)(2)
val multiplyCurriedFour = multiplyCurried(4)
multiplyCurriedFour(2)
multiplyCurriedFour(4)

//Currying allows you to create specialized versions of generalized functions:

def customFilter(f: Int => Boolean)(xs: List[Int]) =
  xs filter f
def onlyEven(x: Int) = x % 2 == 0
val xs = List(12, 11, 5, 20, 3, 13, 2)
customFilter(onlyEven)(xs)

val onlyEvenFilter = customFilter(onlyEven) _
onlyEvenFilter(xs)