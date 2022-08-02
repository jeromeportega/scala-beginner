package lectures.part2oop

object Inheritance extends App {

  // Single Class Inheritance
  // Private methods are NOT inherited.
  // Protected methods ARE inherited, but can only be used in private context.
  class Animal {
    val creatureType = "wild"
    def eat = println("nom nom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("crunch crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  // constructors
  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }
  class Adult(name: String, age: Int, idCard: String) extends Person(name, age)

  // overriding
  class Dog(override val creatureType: String) extends Animal {
    override def eat = {
      super.eat
      println("crunch crunch")
    }
  }

  val dog = new Dog("K9")
  dog.eat
  println(dog.creatureType)

  // Type Substitution i.e. Polymorphism
  val unknownAnimal: Animal = new Dog("K9")
  unknownAnimal.eat

  // Super - Reference method or field from parent class.
  // Preventing Overrides
  // 1 - Use the keyword final to lock down the method. `final eat()`
  // 2 - Use the keyword final on the class itself. i.e. `final class Person`
  // 3 - Seal the class meaning you can only extend from within the same file i.e. `sealed class Person`
}
