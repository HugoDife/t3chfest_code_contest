package com.hugodife.problems

object Problem3 {
  def solution(a: Array[Int]): Int = {
    var total = 0
    for(i <- a) {
      total += i.toBinaryString.count(_ == '1')
    }
    total
  }
}
