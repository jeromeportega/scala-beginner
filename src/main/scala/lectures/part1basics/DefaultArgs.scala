package lectures.part1basics

object DefaultArgs extends App {

  def trFact(n: Int, acc: Int = 1): Int =
    if (n <= 1) acc
    else trFact(n - 1, n * acc)

  val fact10 = trFact(10)
  // You can still override default values by passing the argument anyways.

  def savePicture(format: String = "jpg", width: Int, height: Int): Unit = println("saving picture")
  // savePicture(800, 600) Can't do this, confuses the parameter order for the compiler.

  // Solutions:
  // 1. Pass in every leading argument.
  // 2. Name the arguments.

  savePicture(width=800, height=600)
  // This also means that parameters can be passed in out of order.
}
