package es.floppp.fifteen

import scala.io.Source

/**
  * The elves are running low on wrapping paper, and so they need to submit an
  * order for more. They have a list of the dimensions (length l, width w,
  * and height h) of each present, and only want to order exactly as much as
  * they need.
  *
  * Fortunately, every present is a box (a perfect right rectangular prism),
  * which makes calculating the required wrapping paper for each gift a
  * little easier: find the surface area of the box, which
  * is 2*l*w + 2*w*h + 2*h*l. The elves also need a little extra paper for
  * each present: the area of the smallest side.
  *
  * For example:
  *
  * A present with dimensions 2x3x4 requires 2*6 + 2*12 + 2*8 = 52 square
  * feet of wrapping paper plus 6 square feet of slack, for a total of 58
  * square feet.
  * A present with dimensions 1x1x10 requires 2*1 + 2*10 + 2*10 = 42 square
  * feet of wrapping paper plus 1 square foot of slack, for a total of 43
  * square feet.
  * All numbers in the elves' list are in feet. How many total square feet
  * of wrapping paper should they order?
 */
class Day2IWasToldThereWouldBeNoMath {
  private def combinations(ls: Array[Int]): Array[(Int, Int)] = {
    for {
      l <- ls
      m <- ls
      if (l != m)
    } yield (l, m)
  }

  def xcombinations(ls: List[Int], n: Int): List[List[Int]] = ls match {
    case _ :: _ if n == 1 => ls.map(List(_))
    case hd :: tl => xcombinations(tl, n - 1).map(hd :: _) ::: xcombinations(tl, n)
    case _ => Nil
  }

  def getRibbonComputation(line: String): Int = {
    val ls = line.split('x').map(_.toInt).toList
    // val m3 = ls.reduce(_ * _)
    ls.sorted.take(2).map(2 * _).reduce(_ + _) + ls.reduce(_ * _)
  }

  def getSurfaceComputation(line: String): Int = {
    val ls = line.split('x').map(_.toInt).toList
    var min = 1000000000
    xcombinations(ls, 2)
      .map(p => {
        val t = p(0) * p(1)
        if (t < min)
          min = t
        2 * t
      })
      .reduce((acc, e) => acc + e) + min
  }

  def run(fileName: String) = {
    val r = Source
      .fromFile(fileName)
      .getLines
      .map(getRibbonComputation(_))
      .reduce(_ + _)
    // .foreach(println(_))
    println(getRibbonComputation("2x3x4"))
    println(getRibbonComputation("1x1x10"))
    println(r)
  }

}
