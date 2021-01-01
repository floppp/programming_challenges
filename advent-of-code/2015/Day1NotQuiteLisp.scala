/**
  * Santa was hoping for a white Christmas, but this weather machine's 'snow'
  * funtion is powered by stars, and he's fresh out! To save Christmas, he
  * needs you to cllect fifty starts by December 25th.
  *
  * Collect stars by helping Santa solve puzzles. Two puzzles will be made
  * available on each day in the advent calendar; the second puzzle is
  * unlocked whtn you complete the first. Each puzzle grants one star. Good
  * luck!
  *
  * Here's an easy puzzle to warm you up.
  *
  * Santa is trying to deliver presents in a large apartment building, but he
  * can't find the right floor - the directions he got are a little confusing.
  * He starts on the ground floor (floor 0) and then follows the instructions
  * one character at a time.
  *
  * An opening parenthesis, (, means he should go up one floor, and a closing
  *  parenthesis, ), means he should go down one floor.
  *
  * The apartment building is very tall, and the basement is very deep; he will
  *  never find the top or bottom floors.
  *
  * For example:
  *
  * (()) and ()() both result in floor 0.
  * ((( and (()(()( both result in floor 3.
  * ))((((( also results in floor 3.
  * ()) and ))( both result in floor -1 (the first basement level).
  * ))) and )())()) both result in floor -3.
  *
  * To what floor do the instructions take Santa?
  * ----------
  * Answer => 232
  *
  *
  * Second part: first instruction where we are underground (level -1)
  * ----------
  * Answer => 1783
  */

package es.floppp.fifteen


class Day1NotQuiteLisp {
  def run(instruction: String): Int =
    instruction.toCharArray()
               .foldLeft(0)((acc, c) => if (c == '(') acc + 1 else acc - 1)
  // instruction.count(_ == '(') - instruction.count(_ == ')')
  def run2(instruction: String): Int = {
    var counter: Int = 0
    var acc: Int = 0
    for (c <- instruction.toCharArray()) {
      if (c == '(') acc += 1
      else          acc -= 1

      counter += 1
      if (acc < 0) return counter
    }

    return -1
  }
}
