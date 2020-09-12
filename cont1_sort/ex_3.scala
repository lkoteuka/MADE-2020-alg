package cont1_sort

object ex_3 {
  var counter = 0

  def mergeSort(array: Array[Int], low: Int, high: Int): Unit = {
    if (high <= low) return
    val mid = (low + high) / 2
    mergeSort(array, low, mid)
    mergeSort(array, mid + 1, high)
    merge(array, low, mid, high)
  }

  def merge(array: Array[Int], low: Int, mid: Int, high: Int): Unit = {
    val leftArray = new Array[Int](mid - low + 1)
    val rightArray = new Array[Int](high - mid)

    for (i <- leftArray.indices) {
      leftArray(i) = array(low + i)
    }
    for (i <- rightArray.indices) {
      rightArray(i) = array(mid + i + 1)
    }

    var leftIndex = 0
    var rightIndex = 0

    for (i <- low until high + 1) {
      if (leftIndex < leftArray.length && rightIndex < rightArray.length){
        if (leftArray(leftIndex) <= rightArray(rightIndex)) {
          array(i) = leftArray(leftIndex)
          leftIndex += 1
        }
        else {
          counter += leftArray.length - leftIndex
          array(i) = rightArray(rightIndex)
          rightIndex += 1
        }
      }
      else if (leftIndex < leftArray.length) {
        array(i) = leftArray(leftIndex)
        leftIndex += 1
      }
      else if (rightIndex < rightArray.length) {
        array(i) = rightArray(rightIndex)
        rightIndex += 1
      }
    }
  }

  def main(args: Array[String]) {
    val n = Console.in.readLine.toInt
    val arr = Console.in.readLine.split(" ").map(_.toInt)

//    println(mergeSort(arr).mkString(" "))
    mergeSort(arr, 0, arr.length - 1)
    println(counter)
  }
}
