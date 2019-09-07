//At the top of the collection hierarchy is the trait Traversable. Its only abstract operation is foreach:
//
//def foreach[U](f: Elem => U)

// Collection classes that implement Traversable just need to define this method;
// all other methods can be inherited from Traversable.
//
// The foreach method is meant to traverse all elements of the collection, and apply the given operation, f,
// to each element. The type of the operation is Elem => U, where Elem is the type of the collection's
// elements and U is an arbitrary result type. The invocation of f is done for its side effect only;
// in fact any function result of f is discarded by foreach.
//
//Traversables are the superclass of List, Array, Map, Set, Stream and more.
// The methods involved can be applied to each other in a different type.
// ++ appends two Traversables together.
// The resulting Traversable is the same type of the first element.

val set = Set(1, 9, 10, 22)
val list = List(3, 4, 5, 10)
val result = set ++ list
result.size

val result2 = list ++ set
result2.size

//map will apply the given function on all elements of a Traversable and return a new
// collection of the result:

val set3 = Set(1, 3, 4, 6)
val result3 = set3.map(_ * 4)
result3.lastOption

// flatten will "pack" all child Traversables into a single Traversable:

val list4 = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
list4.flatten

//flatMap will not only apply the given function on all elements of a Traversable,
// but all elements within the elements and flatten the results:

val list5 = List(List(1), List(2, 3, 4), List(5, 6, 7), List(8, 9, 10))
val result5 = list5.flatMap(_.map(_ * 4))
result5

// flatMap of Options will filter out all Nones but keep the Somes:

val list6 = List(1, 2, 3, 4, 5)
val result6 = list6.flatMap(it => if (it % 2 == 0) Some(it) else None)
result6

// collect will apply a partial function to all elements of a Traversable
// and return a different collection. In this exercise, a case fragment
// is a partial function:

val list7 = List(4, 6, 7, 8, 9, 13, 14)
val result7 = list7.collect {
  case x: Int if (x % 2 == 0) => x * 3
}
result7

// Two case fragments can be chained to create a more robust result:

val list8 = List(4, 6, 7, 8, 9, 13, 14)
val partialFunction1: PartialFunction[Int, Int] = {
  case x: Int if x % 2 == 0 => x * 3
}
val partialFunction2: PartialFunction[Int, Int] = {
  case y: Int if y % 2 != 0 => y * 4
}
val result8 = list8.collect(partialFunction1 orElse partialFunction2)
result8

// foreach will apply a function to all elements of a Traversable,
// but unlike the map function, it will not return anything since
// the return type is Unit - an equivalent to a void return type
// in Java/C++:

val list9 = List(4, 6, 7, 8, 9, 13, 14)
list9.foreach(num => println(num * 4))
list9

//toArray will convert any Traversable to an Array,
// which is a special wrapper around a primitive Java array:

val set10 = Set(4, 6, 7, 8, 9, 13, 14)
val result10 = set10.toArray
result10.isInstanceOf[Array[Int]]

// toMap will convert any Traversable to a Map.
// How it's used depends on the original collection;
// if it's a List or Seq, it should be of parameterized type Tuple2:

val list11 = List("Phoenix" -> "Arizona", "Austin" -> "Texas")
val result11 = list11.toMap
result11

//hasDefiniteSize will return true if the traversable has a finite end,
// otherwise false:

val map12 = Map("Phoenix" -> "Arizona", "Austin" -> "Texas")
map12.hasDefiniteSize

import scala.collection.immutable.Stream.cons
val stream12 = cons(0, cons(1, Stream.empty))
stream12.hasDefiniteSize

// headOption will return the first element as an Option of an ordered
// collection, or some random element if order is not defined.
// If a first element is not available, then None is returned:

val list13 = List(10, 19, 45, 1, 22)
list13.headOption

// take is used often with Streams, since they are also Traversable:

def streamer(v: Int): Stream[Int] = cons(v, streamer(v + 1))
val a = streamer(2)
(a take 3 toList)

//drop will take the rest of the Traversable except the number of elements given:

def streamer2(v: Int): Stream[Int] = cons(v, streamer(v + 1))
val a2 = streamer2(2)
((a2 drop 6) take 3).toList

// splitAt will split a Traversable at a position, returning a 2 product Tuple.
// splitAt is also defined as (xs take n, xs drop n)

val array2 = Array(87, 44, 5, 4, 200, 10, 39, 100)
val result22 = array2 splitAt 3
result22._1
result22._2

// span will split a Traversable according to a predicate, returning a 2 product Tuple.
// span is also defined as (xs takeWhile p, xs dropWhile p)

val array33 = Array(87, 44, 5, 4, 200, 10, 39, 100)
val result33 = array33 span (_ < 100)
result33._1
result33._2