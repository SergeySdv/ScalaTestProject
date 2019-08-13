
val a = List(1, 2, 3)

a.map {
  _ * 2
}
a.filter {
  _ % 2 == 0
}

val b = List(1, 3, 5, 7)
b.reduceLeft(_ + _)

b.reduceLeft(_ * _)

val c = (1 to 5).toList
c

val head = List(1, 3)
val tail = List(5, 7)

head ::: tail


head ::: Nil