package com.hugodife.problems

import scala.collection.Searching._

object Problem2 {
  def solution(h: Array[Int]): Int = {
    var aux = List(h(0))
    var total = 0
    for(i <- 1 until h.length) {
      if(h(i) > aux.last)
        aux = aux :+ h(i)
      else if(h(i) < aux.last) {
        val position = getPosition(aux, h(i))
        total += aux.length - position
        if(aux(position) == h(i)){
          total -= 1
        }
        aux = aux.slice(0, position) :+ h(i)
      }
    }
    total + aux.length
  }

  def getPosition(sortedList: List[Int], newElement: Int): Int = {
    sortedList.search(newElement).insertionPoint
  }
}
