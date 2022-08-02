package lectures.part4patternmatching

import scala.util.Random

object PatternMatching extends App {
  // A switch statement on steroids.
  val random = new Random
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "the ONE"
    case 2 => "double or nothing"
    case 3 => "third time is the charm"
    case _ => "something else" // This is the wildcard case that is kinda like default.
  }

  println(x)
  println(description)

  // Pattern Matching
  // Can decompose values (including guards!)
  case class Person(name: String, age: Int)
  val bob = Person("Bob", 20)

  val greeting = bob match {
    case Person(name, age) if age < 21 => s"Hi, my name is $name and I can't drink in the USA."
    case Person(name, age) => s"Hi, my name is $name and I am $age years old."
    case _ => "I don't know who I am."
  }
  println(greeting)

  /**
   * IMPORTANT NOTES
   * 1. Cases are matched in order.
   * 2. If there are no cases that match, it will throw an exception.
   * 3. The Pattern Match expression holds a type that is a unified type of all types in all cases.
   */

  // Pattern Matching on Sealed Hierarchies will issue a compiler warning.  This is good!
  sealed class Animal
  case class Dog(breed: String) extends Animal
  case class Parrot(breed: String) extends Animal

  val animal: Animal = Dog("Terra Nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of $someBreed breed.")
  }

  // Typical error is to try and match everything.  Don't do this!!!
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }
  val isEvenCondition = if (x % 2 == 0) true else false
  val isEvenNormal = x % 2 == 0

  trait NewExpression
  case class Number(n: Int) extends NewExpression
  case class Sum(e1: NewExpression, e2: NewExpression) extends NewExpression
  case class Product(e1: NewExpression, e2: NewExpression) extends NewExpression

  def show(e: NewExpression): String = e match {
    case Number(n) => s"$n"
    case Sum(e1, e2) => show(e1) + " + " + show(e2)
    case Product(e1, e2) => {
      def maybeShowParentheses(exp: NewExpression) = exp match {
        case Product(_, _) => show(exp)
        case Number(_) => show(exp)
        case _ => "(" + show(exp) + ")"
      }
      maybeShowParentheses(e1) + " * " + maybeShowParentheses(e2)
    }
  }

  println(show(Sum(Number(2), Number(3))))
  println(show(Sum(Sum(Number(2), Number(3)), Number(4))))
  println(show(Product(Sum(Number(2), Number(1)), Number(3))))
  println(show(Sum(Product(Number(2), Number(1)), Number(3))))
}
