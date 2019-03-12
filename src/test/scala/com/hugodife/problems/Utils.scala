package com.hugodife.problems

/**
  * Created by Hugodife on 12/03/2019.
  */
object Utils {
  def times(number: Int)(nRepetitions: Int): Array[Int] = {
    (1 to nRepetitions).map(a => number).toArray
  }
}
