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
