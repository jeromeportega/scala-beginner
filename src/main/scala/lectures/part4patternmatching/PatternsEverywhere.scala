package lectures.part4patternmatching

object PatternsEverywhere extends App {

  // Big Idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "Something Else"
  }

  // Catches are actually just type match statements!

  // Big Idea #2 - Generators are also based on pattern matching!
  val list = List(1, 2, 3, 4)
  val evenOnes = for {
    x <- list if x % 2 == 0
  } yield 10 * x

  val tuples = List((1, 2), (3, 4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second

  // Big Idea #3
  val tuple = (1, 2, 3)
  val (a, b, c) = tuple
  // Using name binding property of pattern matching, we can bind multiple vals.

  val head :: tail = list
  println(head)
  println(tail)

  // Big Idea #4
  // Partial Functions are based on pattern matching.
  val mappedList = list.map {
    case v if v % 2 == 0 => v + " is even"
    case 1 => "The One"
    case _ => "Something Else"
  } // Partial Function Literal

  val mappedList2 = list.map { x => x match {
      case v if v % 2 == 0 => v + " is even"
      case 1 => "The One"
      case _ => "Something Else"
    }
  }

  println(mappedList)
  println(mappedList2)
}
