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

  }
}
