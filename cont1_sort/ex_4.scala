package cont1_sort

object ex_4 {
  def main(args: Array[String]) {
    val n : Int = Console.in.readLine.toInt
    val arr: Array[Int] = Console.in.readLine.split(" ").map(_.toInt)

    def quickSort(l: Int, r: Int) {
      val midElement = arr((l + r) / 2)
      var i = l;
      var j = r;
      while (i <= j) {
        while (arr(i) < midElement)
          i += 1
        while (arr(j) > midElement)
          j -= 1
        if (i <= j) {
          val buf = arr(i)
          arr(i) = arr(j)
          arr(j) = buf
          i += 1
          j -= 1
        }
      }
      if (l < j) quickSort(l, j)
      if (j < r) quickSort(i, r)
    }

    quickSort(0, arr.length - 1)
    println(arr.mkString(" "))
  }
}
