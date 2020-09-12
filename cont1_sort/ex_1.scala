object ex_1 {
  def main(args: Array[String]) {
    val n: Int = Console.in.readLine.toInt
    for (_ <- 1 to n){
      println(Console.in.readLine.split(" ").map(_.toInt).sum)
    }
  }
}