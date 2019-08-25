import java.util.Date

val t1 = (1, "hello", Console)

val t2 =  Tuple3(1, "hello", Console)

val tuple = ("apple", "dog")
val fruit = tuple._1
val animal = tuple._2

val tuple5 = ("a", 1, 2.2, new Date(), "five")

tuple5._3
tuple5._4
tuple5._5

val student = ("Sean Rogers", 21, 3.5)
val (name, age, gpa) = student

student._1
student._2
student._3


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
