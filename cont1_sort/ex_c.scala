package cont1_sort

object ex_c {
  def mergeSort(arr: List[Int]): List[Int] = {
    val n = arr.length / 2
    if (n == 0)
      arr
    else {
      def merge(arr_x: List[Int], arr_y: List[Int]): List[Int] = (arr_x , arr_y) match {
        case(Nil, arr_y) => arr_y
        case(arr_x, Nil) => arr_x
        case(x :: arr_x1, y :: arr_y1) =>
          if (x < y)
            x :: merge(arr_x1, arr_y)
          else
            y :: merge(arr_x, arr_y1)
      }
      val (left, right) = arr.splitAt(n)
      merge(mergeSort(left), mergeSort(right))
    }
  }

  def main(args: Array[String]) {
//    val n : Int = Console.in.readLine.toInt
    //val arr: List[Int] = Console.in.readLine.split(" ").map(_.toInt).toList
    val arr = new Array[Int](10000)
    for (i <- 0 until arr.length) { arr(i) = -i }
    val b = arr.toList
    val time = System.currentTimeMillis()
    print(arr.length)
    println(mergeSort(b).mkString(" "))
    print(System.currentTimeMillis() - time)
  }
}
