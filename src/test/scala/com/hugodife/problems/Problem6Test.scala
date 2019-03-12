package com.hugodife.problems

import com.hugodife.problems.Utils._
import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}

@RunWith(classOf[JUnitRunner])
class Problem6Test extends FunSuite with Matchers {

  test("Checking true matrix") {
    time {Problem6.solution(createTrueMatrix(1)) should equal(1)}
    Problem6.solution(createTrueMatrix(2)) should equal(2)
    Problem6.solution(createTrueMatrix(100)) should equal(100)
    time {Problem6.solution(createTrueMatrix(300)) should equal(300)}
  }

  test("Checking false matrix") {
    time {Problem6.solution(createFalseMatrix(1)) should equal(0)}
    time {Problem6.solution(createFalseMatrix(300)) should equal(0)}
  }

  test("Mixed problems") {
    val validMatrix = Array(
      Array(true,  true,  true, false),
      Array(true,  true,  true, false),
      Array(true,  true,  true, false),
      Array(true,  true,  true, true),
      Array(false, true,  true, true),
      Array(true,  false, true, true))
    time {Problem6.solution(validMatrix) should equal(2)}

    val invalidMatrix = Array(
      Array(true,  true,  false, false),
      Array(true,  false,  false, false),
      Array(false,  true,  false, true))
    time {Problem6.solution(invalidMatrix) should equal(0)}

    var midFalse150 = createTrueMatrix(300)
    midFalse150(75)(75) = false
    time {Problem6.solution(midFalse150) should equal(75)}

    var midFalse300 = createTrueMatrix(300)
    midFalse300(150)(150) = false
    time {Problem6.solution(midFalse300) should equal(149)}
  }
}
