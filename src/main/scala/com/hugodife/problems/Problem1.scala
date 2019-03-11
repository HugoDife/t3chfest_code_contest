package com.hugodife.problems

object Problem1 {
  def solution(n: Int, m: Int): Int = {
    val realM = simplifyM(n, m)

    val mod = n % realM

    val div: Int = n / realM


    if(mod == 0) return div


    var lastInit = 0
    var total = 0
    var rest = 0
    do {
      val count = if(lastInit < mod) 1 else 0
      rest = (n - lastInit) % realM
      lastInit = realM - rest
      total += (div + count)
    } while(rest != 0)

    total
  }

  def simplifyM(n: Int, m: Int): Int = {
    if(m > n) m % n
    else if (m < n && m > (n / 2)) n - m
    else m
  }
}
