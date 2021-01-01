/**
* PROJECT EULER
*
* If we list all the natural numbers below 10 that are
* multiples of 3 or 5, we get 3, 5, 6 and 9. The sum
* of these multiples is 23.
* Find the sum of all the multiples of 3 or 5 below 1000.
*
* tags: project-euler easy number-theory
*/
def run: Int = {
  first((0 to 999).toList)
}

def first(xs: List[Int]): Int = {
  val ys = for ( i <- xs if i % 3 == 0 || i % 5 == 0 ) yield i
  ys.sum
}

    // test("##### TEST PROBLEMA 001 ####")
    // {
    //     assert(Main.problema_001((1 to 9).toList) === 23)
    // }