package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}
import Problem5.Node

@RunWith(classOf[JUnitRunner])
class Problem5Test extends FunSuite with Matchers {

  test("Checking whole algorithm") {
    val a = Array(0, 1, 2)
    val b = Array(1, 2, 3)

    Problem5.solution(a, b, 0) should equal(3)
    Problem5.solution(a, b, 1) should equal(1)

    val exampleA = Array(5, 1, 0, 2, 7, 0, 6, 6, 1)
    val exampleB = Array(1, 0, 7, 4, 2, 6, 8, 3, 9)
    Problem5.solution(exampleA, exampleB, 2) should equal(2)

  }

  test("Checking group max length") {
    val nodes = Map(1 -> Node(1, Array(2)), 2 -> Node(2, Array(1)))
    Problem5.computeMaxLength(nodes) should equal(1)
    val nodes2 = Map(1 -> Node(1, Array(2)), 2 -> Node(2, Array(1, 3)), 3 -> Node(3, Array(2)))
    Problem5.computeMaxLength(nodes2) should equal(2)
    val nodes3 = Map(1 -> Node(1, Array(2)), 2 -> Node(2, Array(1, 3, 4)), 3 -> Node(3, Array(2)),
      4 -> Node(4, Array(2, 5)), 5 -> Node(5, Array(4)))
    Problem5.computeMaxLength(nodes3) should equal(3)
  }
}
