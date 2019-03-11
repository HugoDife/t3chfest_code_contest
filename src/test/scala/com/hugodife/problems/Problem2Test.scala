package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class Problem2Test extends FunSuite with Matchers {

  test("All valid answers") {
    Problem2.solution(Array(8, 8, 5, 7, 9, 8, 7, 4, 8)) should equal(7)
    val length = 100000
    Problem2.solution(1 to length toArray) should equal(length)
  }
}
