package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class Problem1Test extends FunSuite with Matchers {

  test("Test no image push formatting") {
    Problem1.solution(10, 4) should equal(5)
    Problem1.solution(10, 1) should equal(10)
    Problem1.solution(15, 5) should equal(3)
    Problem1.solution(1000000000, 5) should equal(200000000)
    Problem1.solution(1000000000, 1) should equal(1000000000)
    Problem1.solution(15, 15) should equal(1)
    Problem1.solution(15, 16) should equal(15)
    Problem1.solution(1000000000, 1) should equal(1000000000)
    Problem1.solution(10, 9) should equal(10)
    Problem1.solution(1000000000, 999999999) should equal(1000000000)
    Problem1.solution(10, 7) should equal(10)
    Problem1.solution(11, 4) should equal(11)
  }
}
