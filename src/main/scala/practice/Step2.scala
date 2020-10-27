package practice

object Step2 extends App {
  val message: String = "Hello yet again, world!"
  println(message);

  def max(x: Int, y: Int): Int = {
    if (x > y) x
    else y
  }
  //同じ
  def max2(x: Int, y: Int) = if (x > y) x else y
  println(max(2,3))

  //while
  var i = 0
  while (i < 3) {
    println(i)
    i += 1
  }

  //foreach
  val fruits = List("みかん","りんご","めろん");
  fruits.foreach(fruit => println(fruit))
  //同じ
  fruits.foreach(println)

  //for文
  for (fruit <- fruits)
    println(fruit)


}
