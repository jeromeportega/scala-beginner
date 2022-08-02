package lectures.part2oop

object Objects extends App {

  // SCALA DOES NOT HAVE CLASS-LEVEL FUNCTIONALITY (no STATIC)
  object Person {
    val N_EYES = 2
    def canFly: Boolean = false

    // Factory Method
    def apply(mother: Person, father: Person): Person = new Person("Bobby")
  }

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala object = SINGLETON INSTANCE
  // Not only does a class definition define a type, but also its only instance.
  val person1 = Person
  val person2 = Person
  println(person1 == person2) // true since they are the same singleton.

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)

  // This will run the apply method kind of like a constructor.
  val bobbie = Person(mary, john)

  // Scala Application - Scala object with
  // def main(args: Array[String]): Unit
}
