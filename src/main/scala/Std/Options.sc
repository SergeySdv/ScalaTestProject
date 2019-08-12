val someValue: Option[Double] = Some(20.0)
val value = someValue match {
  case Some(v) => v
  case None => 0.0
}

val noValue: Option[Double] = None
val value1 = noValue match {
  case Some(v) => v
  case None => 0.0
}

def maybeItWillReturnSomething(flag: Boolean): Option[String] = {
  if (flag) Some("Found value") else None
}

val value3: Option[String] = maybeItWillReturnSomething(true)
val value4: Option[String] = maybeItWillReturnSomething(false)

val number: Option[Int] = Some(3)
val noNumber: Option[Int] = None
val result1 = number.map(_ * 1.5)
val result2 = noNumber.map(_ * 1.5)

val number3: Option[Int] = Some(3)
val noNumber4: Option[Int] = None
val result3 = number3.fold(1)(_ * 3)
val result4 = noNumber4.fold(1)(_ * 3)