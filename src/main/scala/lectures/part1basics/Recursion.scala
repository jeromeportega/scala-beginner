package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): Int =
    if (n <= 1) 1
    else {
      println("Computing factorial of " + n + " - I first need factorial of " + (n - 1))
      val result = n * factorial(n - 1)
      println("Computer factorial of " + n)
//      n * factorial(n - 1)

      result
    }

  factorial(10)

  def anotherFactorial(n: Int): Int = {
    def factorialHelper(x: Int, accumulator: Int): Int =
      if (x <= 1) return accumulator
      else factorialHelper(x - 1, x * accumulator)

    factorialHelper(n, 1)
  }

  anotherFactorial(10)

}
