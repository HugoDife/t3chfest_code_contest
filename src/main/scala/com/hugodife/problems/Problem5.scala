package com.hugodife.problems

object Problem5 {

  val maxLength = 900

  case class Node(id: Int, connections: Array[Int])


  def solution(a: Array[Int], b: Array[Int], k: Int): Int = {
    // write your code in Scala 2.12
    return ???
  }

  def maxPathLength(nodes: Map[Int, Node], k: Int): Int = {
    if(k == 0) computeMaxLength(nodes)
    else {
      nodes.keySet.map(nodeId => {
        // Split in 2
        // max(maxPathLength(nodesSplit1, k - 1), maxPathLength(nodesSplit2, k - 1))
        nodeId
      }).max
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

  def splitGraph(edge: (Int, Int), graph: Map[Int, Node]): (Map[Int, Node], Map[Int, Node]) = {
    val first = edge._1
    val second = edge._2

    val firstNodeConnections = graph(first).connections.filter(_ != second)
    val secondNodeConnections = graph(second).connections.filter(_ != first)

    val firstSubgraph = Map(first -> Node(first, firstNodeConnections))
    val secondSubgraph = Map(second -> Node(second, secondNodeConnections))


    def addMissingNodes(
      subGraph: Map[Int, Node], missingNodes: Array[Int]
    ): Map[Int, Node] = {

      if(missingNodes.isEmpty) subGraph
      else if(subGraph.contains(missingNodes.head)) addMissingNodes(subGraph, missingNodes.tail)
      else {
        val newMissingNodes = missingNodes ++ graph(missingNodes.head).connections
        addMissingNodes(subGraph + (missingNodes.head -> graph(missingNodes.head)), newMissingNodes.distinct.tail)
      }
    }
    (addMissingNodes(firstSubgraph, firstNodeConnections), addMissingNodes(secondSubgraph, secondNodeConnections))
  }
}




