package com.hugodife.problems

object Problem3 {
  def solution(a: Array[Int]): Int = {
    var mult: Long = 1
    var total: Long = 0
    for(i <- a) {
      total += i * mult
      mult = mult * 8
    }
    total.toBinaryString.count(_ == '1')
  }
}
