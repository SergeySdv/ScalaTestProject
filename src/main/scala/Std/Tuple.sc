import java.util.Date

val t1 = (1, "hello", Console)

val t2 = new Tuple3(1, "hello", Console)

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

