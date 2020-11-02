package example
import scala.collection.mutable

object Step3 extends App {
  val greetStrings = new Array[String](3)
  greetStrings(0) = "a"
  //同じ
  greetStrings.update(0,"a")

  //Listの結合
  val li1 = List(1,2)
  val li2 = List(3,4)
  val li3 = li1 ::: li2
  println(li3)

  //先頭に要素追加
  val li4 = 0 :: li3
  println(li4)

  //空リストNil
  val li5 = 1 :: 2 :: 3 :: Nil
  println(li5)

  //タプル
  val pair = (99,"scala")
  println(pair._1)
  println(pair._2)

  //集合(イミュータブル)
  var animals = Set("dog","cat") //イミュータブルな集合で初期化、型推論によりSet[String]と判断されている
  animals += "bird" //新しい要素の追加
  println(animals.contains("human"))

  //集合(ミュータブル)importが必要
  val movieSet = mutable.Set("Hitch", "Poltergeist")
  movieSet += "Sherk"
  println(movieSet)


  //Map
  val number = Map(
    1 -> "I", 2 -> "II", 3 -> "III"
  )
  println(number(2))

}
