//The next trait from the top in the collections hierarchy is Iterable.
// All methods in this trait are defined in terms of an abstract method,
// iterator, which yields the collection's elements one by one.
// The foreach method from trait Traversable is implemented
// in Iterable in terms of iterator. Here is the actual implementation:

//def foreach[U](f: Elem => U): Unit = {
//val it = iterator
//while (it.hasNext) f(it.next())
//}

//  Quite a few subclasses of Iterable override this standard implementation
//  of foreach in Iterable, because they can provide a more efficient
//  implementation. Remember that foreach is the basis of the implementation
//  of all operations in Traversable, so its performance matters.
//
//  Some common iterables are Set, List, Vector, Stacks and Stream.
//  Iterator has two important methods: hasNext, which answers whether
//  the iterator has another element available, and next which returns
//  the next element in the iterator.


val list = List(3, 5, 9, 11, 15, 19, 21)
val it = list.iterator
if (it.hasNext) {
  it.next
}


//  grouped will return fixed-size Iterable chunks of an Iterable:

val list2 = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it2 = list2 grouped 3
it2.next()
it2.next()
it2.next()

//  sliding will return an Iterable that shows a sliding window of an Iterable.

val list3 = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it3 = list3 sliding 3
it3.next()
it3.next()
it3.next()

//  sliding can take the size of the window as well the size of the step during each iteration:

val list4 = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
val it4 = list4 sliding (3, 3)
it4.next()
it4.next()
it4.next()

//  takeRight is the opposite of 'take' in Traversable.
//  It retrieves the last elements of an Iterable:

val list5 = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
list5 takeRight 3

//dropRight will drop a specified number of elements from the right:

val list6 = List(3, 5, 9, 11, 15, 19, 21, 24, 32)
list6 dropRight 3

//zip will stitch two iterables into an iterable of pairs of corresponding elements
// from both iterables.
//
//e.g. Iterable(x1, x2, x3) zip Iterable(y1, y2, y3) will return
// ((x1, y1), (x2, y2), (x3, y3)):

val xs = List(3, 5, 9)
val ys = List("Bob", "Ann", "Stella")
(xs zip ys)

//If two Iterables aren't the same size, then zipAll can provide fillers for what
// it couldn't find a complement for.
//
//e.g. Iterable(x1, x2, x3) zipAll (Iterable(y1, y2), x, y)
// will return ((x1,y1), (x2, y2), (x3, y))):

val xs2 = List(3, 5, 9)
val ys2 = List("Bob", "Ann")
(xs2 zipAll (ys2, -1, "?"))

val xt2 = List(3, 5)
val yt2 = List("Bob", "Ann", "Stella")
(xt2 zipAll (yt2, -1, "?"))

//  zipWithIndex will zip an Iterable with its integer index:

val xs7 = List("Manny", "Moe", "Jack")
xs7.zipWithIndex


//sameElements will return true if the two Iterables produce the same
// elements in the same order:

val xs8 = List("Manny", "Moe", "Jack")
val ys8 = List("Manny", "Moe", "Jack")
(xs8 sameElements ys8)
val xt = List("Manny", "Moe", "Jack")
val yt = List("Manny", "Jack", "Moe")
(xt sameElements yt)
val xs1 = Set(3, 2, 1, 4, 5, 6, 7)
val ys1 = Set(7, 2, 1, 4, 5, 6, 3)
(xs1 sameElements ys1)

val xt1 = Set(1, 2, 3)
val yt1 = Set(3, 2, 1)
(xt1 sameElements yt1) 