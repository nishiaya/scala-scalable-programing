//クラス定義の中には、フィールド(インスタンス変数)とメソッドを配置する、これらをまとめてメンバーと呼ぶ

class ChecksumAccumulator {
  //プライベートにすることで、クラス外からのsumへのアクセスはできなくなる
  private var sum = 0
  def add(b: Byte) = {
    sum += b
  }
  def checksum() = 1
}

  //インスタンス生成
//val acc = new ChecksumAccumulator
//val csa = new ChecksumAccumulator



/*
シングルトンオブジェクト
 */
import scala.collection.mutable

//シングルトンオブジェクトがクラスと同じ名前を持つとき、そのクラスのコンパニオンオブジェクトと呼ぶ
//そのクラス(コンパニオンクラス)とコンパニオンオブジェクトは同じファイルで定義する必要がある
//互いの非公開メンバーにアクセスできる
object ChecksumAccumulator {

  private val cache = mutable.Map.empty[String, Int]

  def calculate(s: String): Int =
    if (cache.contains(s))
      cache(s)
    else {
      val acc = new ChecksumAccumulator  //newできるのはクラスのみなので、ここで生成されているのはChecksumAccumulatorクラスのインスタンスになる
      for (c <- s)
        acc.add(c.toByte)
      val cs = acc.checksum()
      cache += (s -> cs)
      cs
    }
}



//ChecksumAccumulatorオブジェクトの定義があっても、ChecksumAccumulator型の変数は作成できない
//シングルトンオブジェクトは、何らかのコードから初めてアクセスされた時に初期化される
//newできないので、クラスと違ってパラメーターをとることができない

//コンパニオンクラスと同じ名前を共有しないシングルトンオブジェクト＝スタンドアロンオブジェクト

