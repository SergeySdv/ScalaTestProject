def lambda = { x: Int =>
  x + 1
}
def lambda2 = (x: Int) => x + 2
val lambda3 = (x: Int) => x + 3

val lambda4 = new Function1[Int, Int] {
  def apply(v1: Int): Int = v1 - 1
}

def lambda5(x: Int) = x + 1

val result = lambda(3)
val `result1andhalf` = lambda.apply(3)

val result2 = lambda2(3)
val result3 = lambda3(3)
val result4 = lambda4(3)
val result5 = lambda5(3)


def lambda6 = (x: Int) => x + 1
def result6 = lambda6(5)

result6


// A closure is a function which maintains a reference
// to one or more variables outside of the function scope
// (it "closes over" the variables).
// Scala will detect that you are using variables outside
// of scope and create an object instance to hold
// the shared variables.


var incrementer = 1

def closure = { x: Int =>
  x + incrementer
}

val result1 = closure(10)
result1

incrementer = 2

val result7 = closure(10)
result7

