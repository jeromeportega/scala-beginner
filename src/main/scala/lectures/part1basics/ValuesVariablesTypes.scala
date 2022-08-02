package lectures.part1basics

object ValuesVariablesTypes extends App {
  // Values are immutable.
  
  val x: Int = 42
  val aString: String = "Hello, this is a string."
  val aBoolean: Boolean = false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4613
  val aLong: Long = 8475849384324492882
  val aFloat: Float = 2.0
  val aDouble: Double = 2.938
  
  // Variables are mutable.
  
  var aVariable: Int = 4
  aVariable = 5 // Side Effect

  println(aString)

  println(x)
}
