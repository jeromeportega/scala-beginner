package lectures.part2oop

object MethodNotations extends App {

  class Person(val name: String, favoriteMovie: String) {
    def likes(movie: String): Boolean = movie == favoriteMovie
    def hangsOutWith(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def apply(): String = s"Hi, my name is $name and I like $favoriteMovie!"
  }

  val mary = new Person("Mary", "Inception")
  println(mary.likes("Inception"))

  // infix notation = operator notation
  println(mary likes "Inception")

  // `operators` in Scala
  val tom = new Person("Tom", "Fight Club")
  println(mary hangsOutWith tom)

  // ALL OPERATORS ARE METHODS and CAN BE OVERLOADED, i.e. + - / * etc.

  println(mary.apply())
  println(mary()) // Calls the apply method.
}