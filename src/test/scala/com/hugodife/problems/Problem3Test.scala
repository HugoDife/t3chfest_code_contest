package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class Problem3Test extends FunSuite with Matchers {

  test("All valid answers") {
    Problem3.solution(Array(1)) should equal(1)
    Problem3.solution(Array(0, 1)) should equal(1)
    Problem3.solution(Array(1, 1)) should equal(2)
    Problem3.solution(Array(1, 5, 6)) should equal(5)
    val length = 100000
    val input = Utils.times(0)(length) :+ 1
    Problem3.solution(input) should equal(1)
  }
}
