/** PROBLEMA 004
 *
 * A palindromic number reads the same both ways. The largest palindrome
 * made from the produco of two 2-digit numbers is 9009 = 91 x 99.
 * Find the largest palindrome made from the producto or two 3-digit
 * numbers.
 *
 * Answer: 906609
 */
def problema_004() : Int =
{
    def esCapicua(q: Int) : Boolean =
    {
        val q_str = q.toString.map(_.asDigit)
        (q_str reverse) == (q_str)
    }
    val ys = for (i <- (999 to 900 by -1); j <- (999 to i by -1) if (esCapicua(i * j))) yield i * j
    ys max
}

// test("#### TEST PROBLEMA 004 ####")
// {
//     assert(Main.problema_004() === 906609)
// }