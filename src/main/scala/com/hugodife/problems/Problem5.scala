package com.hugodife.problems

object Problem5 {

  val maxLength = 900

  class Node(val id: Int, val connections: Array[Int])


  def solution(a: Array[Int], b: Array[Int], k: Int): Int = {
    // write your code in Scala 2.12
    return ???
  }

  def maxPathLength(nodes: Map[Int, Node], k: Int): Int = {
    if(k == 0) computeMaxLength(nodes)
    else {
      return ???
    }
  }

  def computeMaxLength(nodes: Map[Int, Node]): Int = {
    //Optimize computing only for edges
    nodes.map(node => computeMaxLengthOfNode(node._2, nodes - node._1)).max
  }

  def computeMaxLengthOfNode(originNode: Node, nodes: Map[Int, Node]): Int = {
    def computeAccMaxLengthOfNode(acc: Int, originNode: Node, nodes: Map[Int, Node]): Int = {
      if(!originNode.connections.exists(nodes.keySet.contains))
        return 0
      // Optimization removing some more nodes.
      val newNodes = nodes -- originNode.connections
      originNode.connections
        .filter(nodes.contains)
        .map(nodeId => acc + 1 + computeMaxLengthOfNode(nodes(nodeId), newNodes))
        .max
    }
    computeAccMaxLengthOfNode(0, originNode, nodes)
  }
}




