//  String can be placed in format:

val s = "Hello world!"
"Application %s"format(s)

// Character Literals can be a single character:

val a = 'a'
val b = 'B'

// format(a) is a string format, meaning the "%c".format(x)
//will return the string representation of the char.

"%c".format(a)
"%c".format(b)

// Character Literals can be an escape sequence, including octal or hexidecimal:

val c = 'a' //unicode for a
val d = '\141' //octal for a
val e = '\"'
val f = '\\'

"%c".format(c)
"%c".format(d)
"%c".format(e)
"%c".format(f)