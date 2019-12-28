trait Randomizer[A] {
  def draw(): A
}

class IntRandomizer extends Randomizer[Int] {
  def draw() = {
    import util.Random
    Random.nextInt()
  }
}

val intRand = new IntRandomizer
(intRand.draw <= Int.MaxValue)

classOf[String].getCanonicalName

classOf[String].getSimpleName

trait Randomizer2[A] {
  def draw(): A
}

class IntRandomizer extends Randomizer2[Int] {
  def draw() = {
    import util.Random
    Random.nextInt()
  }
}

val intRand2 = new IntRandomizer
intRand2.isInstanceOf[IntRandomizer]
intRand.isInstanceOf[Randomizer2[Int]]
intRand.draw.isInstanceOf[Int]
