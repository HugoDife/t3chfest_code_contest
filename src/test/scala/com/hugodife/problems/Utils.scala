package com.hugodife.problems

object Utils {
  def times(number: Int)(nRepetitions: Int): Array[Int] = {
    (1 to nRepetitions).map(a => number).toArray
  }

  def createTrueMatrix(size: Int) = {
    (0 until size).map(i => (0 until size).map(x => true).toArray).toArray
  }

  def createFalseMatrix(size: Int) = {
    (0 until size).map(i => (0 until size).map(x => false).toArray).toArray
  }

  def time[R](block: => R): R = {
    val t0 = System.nanoTime()
    val result = block    // call-by-name
    val t1 = System.nanoTime()
    println("Elapsed time: " + (t1 - t0) + "ns")
    result
  }
}
