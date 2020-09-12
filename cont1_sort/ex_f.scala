package cont1_sort
import scala.collection.immutable.HashMap

object ex_f {
  val ht: Map[Character, Integer] = HashMap[Character, Integer](
    ('I', 1),
    ('X', 10),
    ('C', 100),
    ('M', 1000),
    ('V', 5),
    ('L', 50)
  )

  def rtoi(num: String): Int = {
    var intNum = 0
    var prev = 0
    for (i <- num.indices.reverse) {
      val temp: Option[Integer] = ht.get(num.charAt(i))
      if (temp.get < prev)
        intNum -= temp.get
      else
        intNum += temp.get
      prev = temp.get
    }
    intNum
  }

  def main(args: Array[String]) {
    val N = Console.in.readLine.toInt
    val arr:Array[(String, String, Int)] = new Array[(String, String, Int)](N)
    for (i <- arr.indices){
      val buf: Array[String] = Console.in.readLine.split(" ")
      arr(i) = (buf(0), buf(1), rtoi(buf(1)))
    }
//    println(arr.mkString(" "))
    arr.sortBy(x => (x._1, x._3)).foreach(x => println(x._1 + " " + x._2))
  }
}
