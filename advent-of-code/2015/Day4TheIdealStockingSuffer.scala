package es.floppp.fifteen

import scala.io.Source
import scala.annotation.tailrec
import java.security.MessageDigest


/** PART I ---------------
  * Santa needs help mining some AdventCoins (very similar to bitcoins) to
  * use as gifts for all the economically forward-thinking little girls
  * and boys.
  *
  * To do this, he needs to find MD5 hashes which, in hexadecimal, start
  * with at least five zeroes. The input to the MD5 hash is some secret
  * key (your puzzle input, given below) followed by a number in
  * decimal. To mine AdventCoins, you must find Santa the lowest positive
  * number (no leading zeroes: 1, 2, 3, ...) that produces such a hash.
  *
  * For example:
  *
  * If your secret key is abcdef, the answer is 609043, because the MD5
  * hash of abcdef609043 starts with five zeroes (000001dbbfa...), and it
  * is the lowest such number to do so.  If your secret key is pqrstuv,
  * the lowest number it combines with to make an MD5 hash starting with
  * five zeroes is 1048970; that is, the MD5 hash of pqrstuv1048970 looks
  * like 000006136ef....
  */

/** PART II -----------
  * 6 zeros
  */
class Day4TheIdealStockingSuffer {
  def run1(input: String, query: String): Int = {
    val len = query.size
    val instance = MessageDigest.getInstance("MD5")
    @tailrec
    def go(n: Int, h: Array[Byte]): Int = {
      val s = h.map("%02X".format(_)).mkString
      if ((n-1) % 100000 == 0)
        println(s"${n} -> $s")
      if (s.slice(0, len) == query) {
        return n-1
      } else {
        return go(n+1, instance.digest(s"$input$n".getBytes))
      }
    }
    go(0, instance.digest(s"${input}0".getBytes))
  }

  def run2(input: String, query: String): Int = {
    var counter = -1
    var hash = ""
    var string = ""
    val len = query.size
    do {
      counter += 1
      string = s"$input$counter"
      hash = md5(string).map("%02X".format(_)).mkString
      if (counter % 100000 == 0)
        println(s"${counter} -> $hash")

    } while (hash.slice(0, len) != query)

    counter
  }
  def md5(s: String) = {
      MessageDigest.getInstance("MD5").digest(s.getBytes)
  }

  def md5HashString(s: String): String = {
    import java.math.BigInteger
    val md = MessageDigest.getInstance("MD5")
    val digest = md.digest(s.getBytes)
    val bigInt = new BigInteger(1, digest)
    val hashedString = bigInt.toString(24)
    hashedString
  }
}
