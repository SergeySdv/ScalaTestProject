abstract	class	Expr
case	class	Var(name:	String)	extends	Expr
case	class	Number(num:	Double)	extends	Expr
case	 class	 UnOp(operator:	 String,	 arg:	 Expr)
  extends	Expr
case	class	BinOp(operator:	String,
                   left:	Expr,	right:	Expr)	extends	Expr

val	v	=	Var("x")

val	op	=	BinOp("+",	Number(1),	v)

def	simplifyTop(expr:	Expr):	Expr	=	expr	match	{
  case	UnOp("-",	UnOp("-",	e))		=>	e	//	Двойное    отрицание
  case	 BinOp("+",	 e,	 Number(0))	 =>	 e	 //    Прибавление	нуля
  case	 BinOp("*",	 e,	 Number(1))	 =>	 e	 //    Умножение	на	единицу
  case	_	=>	expr
}

simplifyTop(UnOp("-",	UnOp("-",	Var("x"))))


val stuff = "blue"

val myStuff = stuff match {
  case "red" =>
    println("RED");
  case "blue" =>
    println("BLUE");
  case "green" =>
    println("GREEN");
  case _ =>
    println(stuff);  // case _ will trigger if all other cases fail.
}

myStuff

//Pattern matching can return complex values:

val stuff2 = "blue"

val myStuff2 = stuff match {
  case "red" => (255, 0, 0)
  case "green" => (0, 255, 0)
  case "blue" => (0, 0, 255)
  case _ => println(stuff); 0
}

println(myStuff2)

//Pattern matching can match complex expressions:

def goldielocks(expr: Any) = expr match {
  case ("porridge", "Papa") => "Papa eating porridge"
  case ("porridge", "Mama") => "Mama eating porridge"
    case("porridge", "Baby") => "Baby eating porridge"
  case _ => "what?"
}
goldielocks(("porridge", "Baby"))
goldielocks(("porridge", "Mama"))
goldielocks(("porridge", "Papa"))
goldielocks(("porridge"))

//Pattern matching can wildcard parts of expressions:

def goldilocks2(expr: Any) = expr match {
  case ("porridge", _) => "eating"
  case ("chair", "Mama") => "sitting"
  case ("bed", "Baby") => "sleeping"
  case _ => "what?"
}

goldilocks2(("porridge", "Papa"))
goldilocks2(("chair", "Mama"))

//A backquote can be used to refer to a stable variable in scope
// to create a case statement - this prevents "variable shadowing":
val foodItem = "porridge"

def goldilocks(expr: Any) = expr match {
  case (`foodItem`, _) => "eating"
  case ("chair", "Mama") => "sitting"
  case ("bed", "Baby") => "sleeping"
  case _ => "what?"
}

goldilocks(("porridge", "Papa"))
goldilocks(("chair", "Mama"))
goldilocks(("porridge", "Cousin"))
goldilocks(("beer", "Cousin"))

//To pattern match against a List, the list can be split
// into parts, in this case the head x and the tail xs.
// Since the case doesn't terminate in Nil,
// xs is interpreted as the rest of the list:
val secondElement = List(1, 2, 3) match {
  case x :: xs => xs.head
  case _ => 0
}

secondElement

//To obtain the second element you can expand on the pattern.
// Where x is the first element, y is the second element,
// and xs is the rest:

val secondElement2 = List(1, 2, 3) match {
  case x :: y :: xs => y
  case _ => 0
}

secondElement2