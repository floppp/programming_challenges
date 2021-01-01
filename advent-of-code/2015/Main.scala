package es.floppp.fifteen

import scala.io.Source
import java.security.MessageDigest

object Main
{
  def main(args: Array[String]): Unit = {
    // val instruction = Source.fromFile("problem-1-input.txt").getLines.mkString
    // println(instruction.length())
    // println((new Day1NotQuiteLisp()).run(instruction))
    // println((new Day1NotQuiteLisp()).run2(instruction))
    // new Day2IWasToldThereWouldBeNoMath().run("day-2-input.txt")
    // println(new Day3PerfectSphericalHouse().run2("day-3-input.txt"))
    // println(new Day3PerfectSphericalHouse().run("^v"))
    // println(new Day3PerfectSphericalHouse().run("^>v<"))
    // println(new Day3PerfectSphericalHouse().run("^v^v^v^v^v"))
    // println(new Day4TheIdealStockingSuffer().run1("bgvyzdsv", "000000"))//"bgvyzdsv"))
    (new Day5).run("day-5-input.txt")
  }
}
