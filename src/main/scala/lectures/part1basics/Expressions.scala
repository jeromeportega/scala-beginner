package lectures.part1basics

object Expressions extends App {
  val x  = 1 + 2 // Expression

  println(x)
  println(2 + 3 * 4) // Follows P E M D A S
  // + - * / & | ^ << >> >>>

  println(1 == x) // Will print a boolean.
  // == != > >= < <=

  println(!(1 == x))
  // ! && ||

  var aVariable = 2
  aVariable += 3 // Will add itself.
  // Reflexive Operators include: -= *= /= +=

  // Instructions (DO) vs Expressions (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if (aCondition) 5 else 3
  println(aConditionValue)
  println(1 + 3)

  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }
  // NEVER WRITE THIS AGAIN. Loops don't really belong in Scala!
  // EVERYTHING in Scala is an EXPRESSION

  val aWeirdValue = (aVariable = 3) // Unit === void
  // Only value that Unit type can hold is `()`
  println(aWeirdValue)

  // Side effects i.e. expressions that return the Unit type: println(), whiles, reassigning

  // Code blocks
  val aCodeBlock = {
    val y = 2
    val z = y + 1

    if (z > 2) "hello" else "Goodbye"
  }

  // 1. Difference between "hello world" and println("hello world")
  // 2. What is the value of:

  val someValue = {
    2 < 3
  }

  val someOtherValue = {
    if(someValue) 239 else 986
    42
  }
}
