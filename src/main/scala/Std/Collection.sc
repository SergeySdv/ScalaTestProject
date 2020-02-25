//  List,
// the immutable linked-list described in detail in the previous chapter. Lists sup-
// port fast addition and removal of items to the beginning of the list, but they
// do not provide fast access to arbitrary indexes because the implementation
// must iterate through the list linearly.

val colors = List("red", "green", "blue")

colors.head

colors.tail

// Arrays allow you to hold a sequence of elements and efficiently access an
// element at an arbitrary position, both to get or update the element, with a
// zero-based index. Here’s how you create an array whose size you know, but
// for which you don’t yet know the element values:

val fiveInts = new Array[Int](5)

val fiveToOne = Array(5, 4, 3, 2, 1)

fiveInts(0) = fiveToOne(3)

fiveInts

// List buffers
// Another alternative, which avoids the reverse operation, is to use a
// ListBuffer. A ListBuffer is a mutable object (contained in package
// scala.collection.mutable), which can help you build lists more efﬁ-
// ciently when you need to append. ListBuffer provides constant time ap-
// pend and prepend operations. You append elements with the += operator,
// and prepend them with the +: operator. When you’re done building, you can
// obtain a List by invoking toList on the ListBuffer

import scala.collection.mutable.ListBuffer

val buf = new ListBuffer[Int]

buf += 1

buf += 10

buf

3 +: buf

buf.toList

// Array Buffer
// An ArrayBuffer is like an array, except that you can additionally add and
// remove elements from the beginning and end of the sequence. All Array
// operations are available, though they are a little slower due to a layer of
// wrapping in the implementation. The new addition and removal operations
// are constant time on average, but occasionally require linear time due to the
// implementation needing to allocate a new array to hold the buffer’s contents.

import scala.collection.mutable.ArrayBuffer

val ArrBuf = new ArrayBuffer[Int]()

ArrBuf += 12
ArrBuf += 15
ArrBuf

ArrBuf.length
ArrBuf(0)
