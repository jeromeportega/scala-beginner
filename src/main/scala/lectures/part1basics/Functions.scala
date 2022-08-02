package lectures.part1basics

object Functions extends App {

  def aFunction(a: String, b: Int): String =
    a + " " + b

  def aDifferentFunction(a: String, b: Int): String = {
    a + " " + b
  }

  println(aFunction("hello", 3))

  def aParameterLessFunction(): Int = 42
  println(aParameterLessFunction())

  def aRepeatedFunction(aString: String, n: Int): String = {
    if (n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }
  println(aRepeatedFunction("hello", 3))
  // WHEN YOU NEED LOOPS, USE RECURSION FOR FUNCTIONAL PROGRAMMING!

  def aFunctionWithSideEffects(aString: String): Unit = println(aString)
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int) = a + b

    aSmallerFunction(n, n - 1)
  }

  /*
  * 1. A greeting function (name, age) => "Hi, my name is $name and I am $age years old"
  * 2. Factorial function 1 * 2 * 3 ... * n
  * 3. Fibonnaci function 1, 1, 2, 3, 5, 8, 13..... f(n - 1) + f(n - 2)
  * 4. Tests if a number is prime.
  */

  def greetingForKids(name: String, age: Int): String =
    "Hi, my name is " + name + " and I am " + age + " years old."
  println(greetingForKids("David", 12))

  def factorial(n: Int): Int =
    if (n <= 0) 1
    else n * factorial(n - 1)
  println(factorial(5))

  def fibonnaci(n: Int): Int =
    if (n <= 1) 1
    else fibonnaci(n - 1) + fibonnaci(n - 2)
  println(fibonnaci(8))

  def isPrime(n: Int): Boolean = {
    def isPrimeUntil(t: Int): Boolean =
      if (t <= 1) true
      else n % t != 0 && isPrimeUntil(t - 1)

    isPrimeUntil(n / 2)
  }
  println(isPrime(37))

}
