package lectures.part2oop

object AbstractDataTypes extends App {

  // Abstract
  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    def eat: Unit = println("crunch crunch")
  }

  // Traits
  trait Carnivore {
    def eat(animal: Animal): Unit
  }

  class Crocodile extends Animal with Carnivore {
    val creatureType: String = "croc"
    def eat: Unit = "nom nom nom"
    def eat(animal: Animal): Unit = s"I'm a croc and I'm eating ${animal.creatureType}"
  }

  val dog = new Dog
  val croc = new Crocodile

  croc.eat(dog)
}
