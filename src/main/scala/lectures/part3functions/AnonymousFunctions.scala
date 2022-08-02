package lectures.part3functions

object AnonymousFunctions extends App {
//  val doubler = new Function1[Int, Int] {
//    override def apply(x: Int): Int = x * 2
//  }

  // Anonymous Function the same as above.  AKA Lambda.
  // val doubler: Int => Int = x => x * 2
  val doubler = (x: Int) => x * 2

  // multiple params in a lambda
  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  // no params
  val justDoSomething: () => Int = () => 3

  // Prints out the function itself.  Must call with parans.
  println(justDoSomething)

  // Prints out the result of the call.
  println(justDoSomething())

  // Curly braces with lambdas.
  val stringToInt = { (str: String) => str.toInt }

  // MORE syntactic sugar (WARNING: Extremely contextual and might confuse the compiler.)
  val niceIncrementer: Int => Int = _ + 1 // Equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _ // Equivalent to (a, b) => a + b


}
