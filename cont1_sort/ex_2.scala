package cont1_sort

object ex_2 {
  def main(args: Array[String]) {
    val n: Int = Console.in.readLine.toInt
    val arr: Array[Int] = Console.in.readLine.split(" ").map(_.toInt)
    for (i <- arr.indices){
      var j = i
      while ( j > 0 && arr(j - 1) > arr(j) ){
        val buf = arr(j)
        arr(j) = arr(j - 1)
        arr(j - 1) = buf
        j -= 1
      }
    }
    println(arr.mkString(" "))
  }
}