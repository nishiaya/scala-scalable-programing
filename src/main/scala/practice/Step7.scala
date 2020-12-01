package practice

class Step7 extends App {

  //if式
  var filename = "default.txt"
  if (!args.isEmpty)
    filename = args(0)

  //同様
  val filename =
    if (!args.isEmpty) args(0)
    else "default.txt"


  //while 最大公約数
  def gcdLoop(x: Long, y: Long): Long = {
    var a = x
    var b = y
    while (a != 0) {
      val temp = a
      a = b % a
      b = temp
    }
    b
  }

  //do-while
  var line = ""
  do {
    line = readLine()
    println("Read:" + line)
  } while (line != "")

  //一般に、varを避けるのと同様にwhileループも避けるほうがよい



  //for式
  val fileHere = (new java.io.File(",")).listFiles
  for (file <- fileHere) //ジェネレーターと呼ばれる
    println(file)

  //フィルター付き
  val fileHere = (new java.io.File(",")).listFiles
  for (file <- fileHere if file.getName.endsWith(".scala"))
    println(file)

  //yield
  //値を反復性性して記憶しておく
  def scalaFiles =
    for {
      file <- fileHere
      if file.getName.endsWith(".scala")
    } yield file


  //try-catch
  def throws3 {
    import java.io.FileReader
    import java.io.FileNotFoundException
    import java.io.IOException

    try {
      val f = new FileReader("input.txt")
      // Use and close file
      println("f [" + f + "]")
    } catch {
      case ex: FileNotFoundException => // Handle missing file
        println("ex [" + ex + "]")
      case ex: IOException => // Handle other I/O error
        println("ex [" + ex + "]")
    }
  }

  //try-finally
  //式がどのような終わり方をしても実行したいコードがあるとき
  def finally1 {
    import java.io.FileReader

    val file = new FileReader("input.txt")
    try {
      // Use the file
    } finally {
      file.close()  // Be sure to close the file
    }
  }

  //match式
  object Match {
    def match1(args: Array[String]) {
      val firstArg = if (args.length > 0) args(0) else ""

      firstArg match {
        case "salt" => println("pepper")
        case "chips" => println("salsa")
        case "eggs" => println("bacon")
        case _ => println("huh?")
      }
    }
  }
}
