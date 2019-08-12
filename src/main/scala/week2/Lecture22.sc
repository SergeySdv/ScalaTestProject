
def name: String = System.getProperty("user.name")
println("Hello, " + name + "!")

def fibIter (a: Long, b: Long, count: Long): Long ={
 if(count == 0 ) b else fibIter(a + b, a, count - 1)
}

def fib2 (n: Long) = fibIter(1, 0 , n)

fib2(90)

def sumItegers(a: Int, b: Int): Int =
 if(a > b) 0 else a + sumItegers(a + 1, b)

sumItegers(10, 20)


// Higher-order Functions

def sum(f: Int => Int, a: Int, b: Int): Int =
if(a > b) 0
else f(a) + sum(f, a + 1, b)

def fact(x: Int): Int = if(x == 0) 1 else x* fact(x - 1)
def cube(x: Int): Int = x * x * x
def id(x: Int): Int = x

def sumInts(a: Int, b: Int) = sum(id , a, b)
def sumCubes(a: Int, b: Int) = sum(cube, a, b)
def sumFactorials(a: Int, b: Int) = sum(fact, a ,b)

sumInts(1, 4)

sumCubes(1, 5)

sumFactorials(1, 6)

fact(10)

// Anonymous Function

println("!!! Anonymous Function")

def sumIntsAnonymous(a: Int, b: Int) = sum(x => x, a, b)
def sumCubesAnonymous(a: Int, b: Int) = sum(x => x * x * x, a, b)
def sumFactorialsAnonymous(a: Int, b: Int) = sum(fact, a ,b)

sumIntsAnonymous(1, 4)

sumCubesAnonymous(1, 5)

// Sum Tail style

def sumTail(f: Int => Int, a: Int, b: Int): Int = {
  def loop(a: Int, acc: Int): Int = {
    if(a > b) acc
    else loop(a + 1, f(a) + acc)
  }
  loop(a, 0)
}

sumTail(x => x * x, 3, 5)

// Function Returning function

println("!!! Function Returning function")

def sumFuncRet(f: Int => Int): (Int, Int) => Int = {
  def sumF(a: Int, b: Int): Int =
    if(a > b) 0
    else f(a) + sumF(a + 1, b)
  sumF
}

def sumIntsFuncRet  = sumFuncRet(x => x)
def sumCubesFuncRet = sumFuncRet(x => x * x * x)
def sumFactorialsFuncRet = sumFuncRet(fact)

// println("here")
// val i = sumFuncRet(x => x)(0, 5)

sumCubes(1, 10) + sumFactorials(10, 20)

sumCubesFuncRet(1, 10) + sumFactorialsFuncRet(10, 20)

// Multiple Parameter List (MPL)

def sumMPL(f: Int => Int)(a: Int, b: Int): Int =
  if (a > b) 0 else f(a) + sumMPL(f)(a + 1, b)

sumMPL(cube)(1, 5)

// Exercise 2.2

def mapReduce(f: Int => Int, combine:(Int, Int) => Int, zero: Int)(a: Int, b: Int): Int =
  if(a > b) zero
  else combine(f(a), mapReduce(f, combine, zero)(a + 1, b))

def product(f: Int => Int)(a: Int, b: Int): Int = mapReduce(f, (x, y) => x * y, 1)(a, b)

product(id)(1, 4)

product(x => x * x)(3, 4)

def factorial(n: Int) = product(x => x)(1, n)

factorial(10)

