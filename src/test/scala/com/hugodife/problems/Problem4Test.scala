package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class Problem4Test extends FunSuite with Matchers {

  test("All basic cases") {
    Problem4.solution(Array()) should equal(0)
    Problem4.solution(Array(1)) should equal(2)
    Problem4.solution(Array(20)) should equal(2)
    Problem4.solution((1 to 7).toArray) should equal(7)
    Problem4.solution((1 to 30).toArray) should equal(25)
  }

  test("More complex") {
    Problem4.solution(Array(1, 2, 4, 5, 7, 29, 30)) should equal(11)
    Problem4.solution(Array(1, 4, 5, 7, 8, 10, 29, 30)) should equal(13)
    Problem4.solution(Array(1, 3, 4, 5, 7, 8, 9, 11)) should equal(11)
    Problem4.solution(Array(1, 3, 4, 5, 7, 15, 16, 17, 20)) should equal(14)
  }

  test("Group checker") {
    Problem4.first7DayGroupIndex(Array(1)) should equal(None)
    Problem4.first7DayGroupIndex(Array(20)) should equal(None)
    Problem4.first7DayGroupIndex((1 to 7).toArray) should equal(Some(0))
    Problem4.first7DayGroupIndex((1 to 30).toArray) should equal(Some(0))
    Problem4.first7DayGroupIndex(Array(1, 2, 8, 9, 10, 11)) should equal(Some(2))
  }

  test("End group checker") {
    Problem4.endIndexOf7DayGroup(Array(1, 2, 3, 4)) should equal(3)
    Problem4.endIndexOf7DayGroup(Array(1, 3, 5, 6, 7, 8)) should equal(4)
    Problem4.endIndexOf7DayGroup((1 to 9).toArray) should equal(6)
  }
}
