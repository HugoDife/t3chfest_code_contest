package com.hugodife.problems

object Problem1 {
  def solution(n: Int, m: Int): Int = {
    val realM = if(n >= m) m else m % n

    def recursive(prevInits: Int): Int = {
      val rest = (n - prevInits) % realM

      if(rest ==0)
        1
      else
        recursive(realM - rest) + 1
    }

    if(n % realM == 0)
      return n / realM

    1 + n / realM * recursive(0)
  }
}
