package es.floppp.fifteen

/**
 * --- Day 5: Doesn't He Have Intern-Elves For This? ---
 *
 * Santa needs help figuring out which strings in his text file are
 * naughty or nice.
 *
 * A nice string is one with all of the following properties:
 *
 * It contains at least three vowels (aeiou only), like aei, xazegov, or
 * aeiouaeiouaeiou.  It contains at least one letter that appears twice
 * in a row, like xx, abcdde (dd), or aabbccdd (aa, bb, cc, or dd).  It
 * does not contain the strings ab, cd, pq, or xy, even if they are part
 * of one of the other requirements.  For example:
 *
 * ugknbfddgicrmopn is nice because it has at least three vowels
 * (u...i...o...), a double letter (...dd...), and none of the disallowed
 * substrings.  aaa is nice because it has at least three vowels and a
 * double letter, even though the letters used by different rules
 * overlap.  jchzalrnumimnmhp is naughty because it has no double letter.
 * haegwjzuvuyypxyu is naughty because it contains the string xy.
 * dvszwmarrgswjxmb is naughty because it contains only one vowel.  How
 * many strings are nice?
  */

/**
  * ---- PART II ----
  * Realizing the error of his ways, Santa has switched to a better model
  * of determining whether a string is naughty or nice. None of the old
  * rules apply, as they are all clearly ridiculous.
  *
  * Now, a nice string is one with all of the following properties:
  *
  *  - It contains a pair of any two letters that appears at least twice in
  * the string without overlapping, like xyxy (xy) or aabcdefgaa (aa), but
  * not like aaa (aa, but it overlaps).
  *  - It contains at least one letter
  * which repeats with exactly one letter between them, like xyx,
  * abcdefeghi (efe), or even aaa.  For example:
  *
  * qjhvhtzxzqqjkmpb is nice because is has a pair that appears twice (qj)
  * and a letter that repeats with exactly one letter between them (zxz).
  * xxyxx is nice because it has a pair that appears twice and a letter
  * that repeats with one between, even though the letters used by each
  * rule overlap.  uurcxstgmygtbstg is naughty because it has a pair (tg)
  * but no repeat with a single letter between them.  ieodomkazucvgmuy is
  * naughty because it has a repeating letter with one between (odo), but
  * no pair that appears twice.
  * How many strings are nice under these new rules?
  */
import scala.io.Source

class Day5 {
  val vowels: Set[Char] = Set('a', 'e', 'i', 'o', 'u')
  val forbidden: Set[Pair[Char, Char]] = Set(('a', 'b'),
    ('c', 'd'),
    ('p', 'q'),
    ('x', 'y')
  )

  def threeVowels(s: String): Boolean =
    s.filter { c => vowels contains c }.length > 2

  def hasForbiddenPair(s: String): Boolean = {
    val len = s.length()
    val fst = s.substring(0, len - 1)
    val scd = s.substring(1, len)
    (fst zip scd).filter(p => forbidden contains p).length > 0

  }

  def twiceInARow(s: String): Boolean = {
    val len = s.length()
    val fst = s.substring(0, len - 1)
    val scd = s.substring(1, len)
    (fst zip scd).filter(p => p._1 == p._2).length > 0
  }

  def run1(fileName: String): Unit = {
    // val lines = for {
    //   line <- Source.fromFile(fileName).getLines
    //   if (threeVowels(line))
    //   if (twiceInARow(line))
    //   if (!hasForbiddenPair(line))
    //     } yield (line)
    // println(lines.length)
    val len = Source.fromFile(fileName).getLines
      .filter(line => threeVowels(line) && twiceInARow(line) && !hasForbiddenPair(line))
      .length
    println(len)
  }

  def run(fileName: String): Unit = {
    run2(fileName)
  }

  // No funciona con xxyxx
  def arePairsNotOverlapping_(s: String): Boolean = {
    val pairs = s.replaceAll("(..)", "$1 ").split(' ').filter(_.length == 2)
    val set = pairs.toSet
    pairs.length != set.size
  }

  def arePairsNotOverlapping(s: String): Boolean = {
    val len = s.length
    val fst = s.substring(0, len-1)
    val scd = s.substring(1, len)

    val pairs = fst zip scd
    var flag = false

    true
  }

  def isLetterBetweenSameLetter(s: String): Boolean =
    s.inits.flatMap(_.tails)
      .filter(_.length == 3)
      .filter(t => t(0) == t(2))
      .length > 0

  def run2(fileName: String): Unit = {
    // val lines = for {
    //   line <- Source.fromFile(fileName).getLines
    //   if isLetterBetweenSameLetter(line)
    //   if arePairsNotOverlapping(line)
    // } yield (line)
    // print(lines.length)
    // lines.foreach(println(_))
    val s = "xxyxx"
    println(
      arePairsNotOverlapping(s) && isLetterBetweenSameLetter(s)
    )
  }
}
