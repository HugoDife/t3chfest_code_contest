package com.hugodife.problems

object Problem3 {
  def solution(a: Array[Int]): Int = {
    a.map(_.toBinaryString.count(_ == '1')).sum
  }
}
