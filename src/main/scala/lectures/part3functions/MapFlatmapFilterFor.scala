package lectures.part3functions

object MapFlatmapFilterFor extends App {
  val list = List(1, 2, 3)
  println(list)
  println(list.head)
  println(list.tail)

  // Map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number."))

  // Filter
  println(list.filter(_ % 2 == 0))

  // flatMap
  val toPair = (x: Int) => List(x, x + 1)
  println(list.flatMap(toPair))

  val numbers = List(1, 2, 3, 4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("Black", "White")
  // List("a1", "a2", "a3", "a4")

  val combinations = numbers.flatMap(n => chars.map(c => "" + c + n))
  println(combinations)

  val moreComplexCombinations = numbers.flatMap(n => chars.flatMap(c => colors.flatMap(l => "" + n + c + "-" + l)))

  // FOR COMPREHENSIONS
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // This filters the call for numbers val only.  CRAZY!!!!
    c <- chars
    l <- colors
  } yield "" + n + c + "-" + l

  for {
    n <- numbers
  } println(n)

  list.map(x => x * 2)
}

// Options: Possible absence of a value.
abstract class Maybe[+T] {
  def map[B](f: T => B): Maybe[B]
  def flatMap[B](f: T => Maybe[B]): Maybe[B]
  def filter(p: T => Boolean): Maybe[T]
}

case object MaybeNot extends Maybe[Nothing] {
  def map[B](f: Nothing => B): Maybe[B] = MaybeNot
  def flatMap[B](f: Nothing => Maybe[B]): Maybe[B] = MaybeNot
  def filter(p: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+T](value: T) extends Maybe[T] {
  def map[B](f: T => B): Maybe[B] = Just(f(value))
  def flatMap[B](f: T => Maybe[B]): Maybe[B] = f(value)
  def filter(p: T => Boolean): Maybe[T] = if (p(value)) this else MaybeNot
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))
}
