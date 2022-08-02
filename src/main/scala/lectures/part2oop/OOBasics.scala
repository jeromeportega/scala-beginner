package lectures.part2oop

object OOBasics extends App {
  val person = new Person("John", 26)

  println(person.age)
  person.greet("Daniel")

  val author: Writer = Writer("Charles", "Dickens", 1812)
  val impostor: Writer = Writer("Charles", "Dickens", 1812)
  val novel: Novel = Novel("Great Expectations", 1861, author)

  println(novel.authorAge)
  println(novel.isWrittenBy(author))
  println(novel.isWrittenBy(impostor))

  val counter = new Counter
  counter.inc.print
  counter.inc.inc.inc.print
}

// constructor
// class parameters are not considered fields. You must assign them with `val`.
class Person(name: String, val age: Int) {
  // Body
  // Declaring values in this way make them class fields.
  val x = 2
  println(x)

  // Here, if there's a reference to name, it is assumed to be this.name
  def greet(): Unit = println(s"Hi, I am ${name}")

  // Overloading
  // You must differentiate this.name or name if there is an incoming param by the same name.
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name!")

  // overloading constructors
  // Calls original constructor with kind of a default value.
  def this(name: String) = this(name, 0)
}

// Sample Structure
class Writer(firstName: String, surname: String, val year: Int) {
  def fullName: String = s"$firstName $surname"
}

class Novel(name: String, year: Int, author: Writer) {
  def authorAge = year - author.year
  def isWrittenBy(author: Writer) = author == this.author
  def copy(newYear: Int): Novel = new Novel(name, newYear, author)
}

// Demonstrates immutability of the object
// Also overloading and no parens on methods with no params.
class Counter(val count: Int = 0) {
  def inc = {
    println("incrementing")
    new Counter(count + 1) // immutability
  }
  def inc(n: Int): Counter = {
    if (n <= 0) this
    else inc.inc(n - 1)
  }
  def dec = {
    println("Decrementing")
    new Counter(count - 1)
  }
  def dec(n: Int): Counter = {
    if (n <= 0) this
    else dec.dec(n - 1)
  }

  def print = println(count)
}
