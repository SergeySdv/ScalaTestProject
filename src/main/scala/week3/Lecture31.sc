

abstract class IntSet{
  def contains(x: Int): Boolean
  def incl(x: Int): IntSet
  def union(other: IntSet): IntSet
}


class NonEmpty(elem: Int, left: IntSet, right: IntSet) extends  IntSet {

  def contains(x: Int): Boolean =
    if(x < elem) left contains x
    else if(x > elem) right contains x
    else true

  def incl(x: Int): IntSet =
    if(x < elem) new NonEmpty(elem, left incl x, right)
    else if(x > elem) new NonEmpty(elem, left, right incl x)
    else this

  def union(other: IntSet): IntSet =
    ((left union right) union other) incl elem

  override def toString = "{" + left + elem + right + "}"

}

//class Empty extends IntSet {
//
//  def contains(x: Int): Boolean = false
//
//  def incl(x: Int): IntSet = new NonEmpty(x, new Empty, new Empty)
//
//  override def toString = "."
//}


//object intsets{
//  val t1 = new NonEmpty(3, new Empty, new Empty)
//  val t2 = t1 incl 4
//  val t3 = t2 incl 2
//
//}


object Empty extends IntSet {

  def contains(x: Int): Boolean = false

  def incl(x: Int): IntSet = new NonEmpty(x, Empty, Empty)

  def union(other: IntSet): IntSet = other

  override def toString = "."
}

object intsets{
  val t1 = new NonEmpty(3, Empty, Empty)
  val t2 = t1 incl 4
  val t3 = t2 incl 2

}
println(intsets.t1.toString)
println(intsets.t2.toString)
println(intsets.t3.toString)