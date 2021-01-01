/**
 * PROBLEMA 006
 *
 * The sum of the squares of the first ten natural numbers is,
 *
 * 1^2 + 2^2 + ... + 10^2 = 385
 *
 * The square of the sum of the first ten natural numbers is,
 *
 * (1 + 2 + ... + 10)^2 = 552 = 3025
 *
 * Hence the difference between the sum of the squares of the
 * first ten natural numbers and the square of the sum is
 * 3025 − 385 = 2640.
 * Find the difference between the sum of the squares of the
 * first one hundred natural numbers and the square of the sum.
 */
def problema_006(x: Int) : Int =
{
    Math.pow((1 to x toList).sum, 2).toInt - (1 to x toList).map(i => i*i).sum
}


// test("#### TEST PROBLEMA 006 ####")
// {
//     assert(Main.problema_006(10) === 2640)
// }