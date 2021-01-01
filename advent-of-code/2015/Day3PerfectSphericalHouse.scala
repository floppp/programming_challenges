package es.floppp.fifteen

import scala.io.Source

/**
  * Santa is delivering presents to an infinite two-dimensional grid of houses.
  *
  * He begins by delivering a present to the house at his starting location,
  * here to move next. Moves are always exactly one house to the north
  * (^), south (v), east (>), or west (<). After each move, he delivers
  * another present to the house at his new location.
  *
  * However, the elf back at the north pole has had a little too much
  * eggnog, and so his directions are a little off, and Santa ends up
  * visiting some houses more than once. How many houses receive at least
  * one present?
  *
  * For example:
  *
  *   - > delivers presents to 2 houses: one at the starting location, and one
  *     to the east.
  *   - ^>v< delivers presents to 4 houses in a square, including twice to
  *     the house at his starting/ending location.
  *   - ^v^v^v^v^v delivers a bunch of presents to some very lucky children at
  *     only 2 houses.
  */
 /**
  * The next year, to speed up the process, Santa creates a robot version
  * of himself, Robo-Santa, to deliver presents with him.
  *
  * Santa and Robo-Santa start at the same location (delivering two
  * presents to the same starting house), then take turns moving based on
  * instructions from the elf, who is eggnoggedly reading from the same
  * script as the previous year.
  *
  * This year, how many houses receive at leahest one present?
  *
  * For example:
  *
  * ^v delivers presents to 3 houses, because Santa goes north, and then
  * Robo-Santa goes south.  ^>v< now delivers presents to 3 houses, and
  * Santa and Robo-Santa end up back where they started.  ^v^v^v^v^v now
  * delivers presents to 11 houses, with Santa going one direction and
  * Robo-Santa going the other.
  */
class Day3PerfectSphericalHouse {
  def run1(fileName: String): Int = {
    var verC: Int = 0
    var horC: Int = 0
    val set: collection.mutable.Set[String] = collection.mutable.Set()


    for (c <- Source.fromFile(fileName).mkString) {
      if (c == '^') verC +=1
      else if (c == 'v') verC -= 1
      else if (c == '>') horC += 1
      else horC -= 1
      set += s"$verC-$horC"
    }

    set.size
  }

  def run2(fileName: String): Int = {
    run(Source.fromFile(fileName).mkString)
  }

  def run(string: String) : Int = {
    var verCS: Int = 0
    var horCS: Int = 0
    var verCR: Int = 0
    var horCR: Int = 0
    val set: collection.mutable.Set[String] = collection.mutable.Set("0-0")
    var flag: Boolean = true

    for (c <- string) {
      if (flag) {
        if (c == '^') verCS +=1
        else if (c == 'v') verCS -= 1
        else if (c == '>') horCS += 1
        else horCS -= 1
        set += s"$verCS-$horCS"
      } else {
        if (c == '^') verCR +=1
        else if (c == 'v') verCR -= 1
        else if (c == '>') horCR += 1
        else horCR -= 1
        set += s"$verCR-$horCR"
      }

      flag = !flag
    }

    set.size
  }

}
