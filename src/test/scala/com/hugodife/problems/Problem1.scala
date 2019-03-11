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
  }

//  test("Test multiple send push formatting") {
//    var multipleNoImageAppJson = "{" + noImageAppJson("1") + "}"
//    for (i <- 2 to 5) multipleNoImageAppJson = multipleNoImageAppJson + "," + "{" + noImageAppJson(i.toString) + "}"
//    multipleNoImageAppJson = multipleNoImageAppJson + "," + "{" + noImageNoDataAppJson + "}"
//    IndigitallRequestGenerator.generate("", "", groupedPush) should equal(wrapMultiple("", "", multipleNoImageAppJson))
//  }
}
