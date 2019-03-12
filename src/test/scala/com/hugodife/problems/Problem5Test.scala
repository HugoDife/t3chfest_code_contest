package com.hugodife.problems

import org.junit.runner.RunWith
import org.scalatest.junit.JUnitRunner
import org.scalatest.{FunSuite, Matchers}
import Problem5.Node

@RunWith(classOf[JUnitRunner])
class Problem5Test extends FunSuite with Matchers {

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
