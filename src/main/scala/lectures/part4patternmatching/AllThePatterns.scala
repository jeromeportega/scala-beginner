package lectures.part4patternmatching

import lectures.part2oop.Generics.MyList

object AllThePatterns extends App {
//  // 1. Constants - i.e. Switch on steroids.
//  val x: Any = "Scala"
//  val constants = x match {
//    case 1 => "A Number"
//    case "Scala" => "THE Scala"
//    case true => "The Truth"
//    case AllThePatterns => "A Singleton Object"
//  }
//
//  // 2. Match Anything
//  // 2.1 Wildcard
//
//  val matchAnything = x match {
//    case _ =>
//  }
//
//  // 2.2 Variable
//  val matchAVariable = x match {
//    case something => s"I've found $something."
//  }
//
//  // 3. Tuples
//  val aTuple = (1, 2)
//  val matchATuple = aTuple match {
//    case (1, 1) =>
//    case (something, 2) => s"I've found $something."
//  }
//
//  val nestedTuple = (1, (2, 3))
//  val matchANestedTuple = nestedTuple match {
//    case(_, (2, v)) =>
//  }
//  // Pattern Matching can be nested, i.e. inside of nested tuples.
//
//  // 4. List Patterns
//  val aStandardList = List(1, 2, 3, 42)
//  val matchAStandardList = aStandardList match {
//    case List(1, _, _, _) => // Extractor for a list - advanced feature
//    case List(1, _*) => // List of arbitrary length - advanced feature
//    case 1 :: List(_) => // Infix pattern
//    case List(1, 2, 3) :+ 42 => // Infix pattern
//  }
//
//  // 5. Type Specifiers
//  val unknown: Any = 2
//  val unknownMatch = unknown match {
//    case list: List[Int] => // Explicit type specifier!
//    case _ =>
//  }
//
//  // 6. Multi-Patterns
//  val multiPattern = aStandardList match {
//    case Nil | List(1) => // Compound Pattern
//  }
//
//  // 7. If Guards
//  val secondElementSpecial = aStandardList match {
//    case List(_, 2, 3, specialElement) if specialElement > 3 =>
//  }

  // ALL

  val numbers = List(1, 2, 3)
  val numbersMatch = numbers match {
    case listOfStrings: List[String] => "A list of strings."
    case listOfNumbers: List[Int] => "A list of numbers."
    case _ => ""
  }

  println(numbersMatch)
  // JVM trick question, since a List[String] matches with a List[Int]
  // JVM reads List[String] as just a generic List
  // This is called "TYPE ERASURE"
}
