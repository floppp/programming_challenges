package project_euler

import org.scalatest.FunSuite
import org.junit.runner.RunWith
// import org.junit.runners.Suite
import org.scalatest.junit.JUnitRunner

@RunWith(classOf[JUnitRunner])
class Problem1Test extends FunSuite
{
    // test("##### TEST PROBLEMA 001 ####")
    // {
    //     assert(Main.problema_001((1 to 9).toList) === 23)
    // }

    // test("##### TEST PROBLEMA 002 ####")
    // {
    //     assert(Main.problema_002(10) === 10)
    // }

    // test("##### TEST PROBLEMA 003 ####")
    // {
    //     assert(Main.problema_003(600851475143L) === 6857)
    // }

    // test("#### TEST PROBLEMA 004 ####")
    // {
    //     assert(Main.problema_004() === 906609)
    // }

    // test("#### TEST PROBLEMA 005 ####")
    // {
    //     assert(Main.problema_005(20) === 232792560)
    // }

    // test("#### TEST PROBLEMA 006 ####")
    // {
    //     assert(Main.problema_006(10) === 2640)
    // }

    test("#### TEST PROBLEMA 007 ####")
    {
        assert(Main.problema_007(10001) === 104743)
    }
}
