//Scala provides a data structure, the array, which stores a fixed-size sequential
// collection of elements of the same type. An array is used to store a collection
// of data, but it is often more useful to think of an array as a collection
// of variables of the same type.

//A list can be converted to an array:

val l = List(1, 2, 3)
val a = l.toArray
a

//Sequences are special cases of iterable collections of class Iterable.
// Unlike iterables, sequences always have a defined order of elements.

//Any sequence can be converted to a list:

val a2 = Array(1, 2, 3)
val s2 = a2.toSeq
val l2 = s2.toList
l2

//You can create a sequence from a for loop:

val s3 = for (v <- 1 to 4) yield v
s3.toList

//You can create a sequence from a for loop with a filter:

val s4 = for (v <- 1 to 10 if v % 3 == 0) yield v
s4.toList

//You can filter any sequence based on a predicate:

val s5 = Seq("hello", "to", "you")
val filtered = s5.filter(_.length > 2)
filtered

//You can also filter Arrays in the same way:

val a6 = Array("hello", "to", "you", "again")
val filtered6 = a6.filter(_.length > 3)
filtered6

//You can map values in a sequence through a function:

val s7 = Seq("hello", "world")
val r7 = s7 map {
  _.reverse
}

r7