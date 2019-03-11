package com.hugodife.problems

object Problem1 {
  def solution(n: Int, m: Int): Int = {
    val mod = n % m
    if(mod == 0)
      return n / m
    var total = Array(0)
    var i = 1
    while (!total.contains((n - total.head) % m)) {
      total =  ((n - total.head) % m) +: total
      total.foreach(print)
      i += 1
    }
    val result = n / m * i
      1 + result
  }
}
