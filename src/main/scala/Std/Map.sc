val myMap = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
myMap.size

val myMap2 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
myMap2.size

val myMap3 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")
val  aNewMap = myMap3 + ("IL" + "Illinois")
aNewMap.contains("IL")

//  Map values can be iterated:

val myMap4 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Michigan")

val mapValues =myMap4.values
mapValues.size
mapValues.head
mapValues.last

//  Maps may be accessed:

val myMap5 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")

myMap5("MI")
myMap5("IA")

//  Maps insertion with duplicate key updates previous entry with subsequent value:

val myMap6 = Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "MI" -> "Meechigan")
val mapValues2 = myMap6.values
mapValues2.size
myMap6("MI")

// If a nonexistent map key is requested using myMap(missingKey),
// a NoSuchElementException will be thrown.
// Default values may be provided using either getOrElse or withDefaultValue
// for the entire map:

//val myMap7 =
//  Map("MI" -> "Michigan", "OH" -> "Ohio", "WI" -> "Wisconsin", "IA" -> "Iowa")
//intercept[NoSuchElementException] {
//  myMap7("TX")
//}

myMap.getOrElse("TX", "missing data")

val myMap8 = Map("MI" -> "Michigan", "OH" -> "Ohio",
  "WI" -> "Wisconsin", "IA" -> "Iowa") withDefaultValue "missing data"
myMap8("TX")
