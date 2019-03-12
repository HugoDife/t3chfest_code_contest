package com.hugodife.problems

object Problem4 {

  val min7DayLength = 4
  val min7DayLengthExclusive = min7DayLength + 1
  val max7GroupIntervals = 6

  val price1D = 2
  val price7D = 7
  val price30D = 25

  def solution(a: Array[Int]): Int = {
    if(a.length == 0) return 0

    a.indices.map(slice => computeValue(slice * price1D, a.drop(slice))).min
  }

  def computeValue(acc: Int, days: Array[Int]): Int = {
      if(days.length < min7DayLength) return acc + days.length * price1D
      if(acc >= price30D) return price30D

      val groupIndex = first7DayGroupIndex(days).getOrElse(return acc + days.length * price1D)
      val groupEndIndex = groupIndex + endIndexOf7DayGroup(days.drop(groupIndex))

      (groupEndIndex to days.length)
        .map(slice => {
          val priceBeforeGroup = groupIndex * price1D
          val priceAfterGroup = (slice - groupEndIndex) * price1D
          computeValue(acc + price7D + priceBeforeGroup + priceAfterGroup, days.drop(slice + 1))
        }).min
  }

  def first7DayGroupIndex(days: Array[Int]): Option[Int] = {
    val groupAndIndex = days.sliding(min7DayLength).zipWithIndex.find{case (arr, ind) => is7DayGroup(arr)}
    val (group, index) = groupAndIndex.getOrElse(return None)
    Some(index)
  }

  private def is7DayGroup(days: Array[Int]): Boolean = {
    days.length >= min7DayLength && (days.last - days.head) <= max7GroupIntervals
  }

  def endIndexOf7DayGroup(days: Array[Int]): Int = {
    var totalInterval = days(3) - days(0)

    for(i <- 4 until days.length) {
      if((days(i) - days.head) > 6)
        return i - 1
    }
    days.length - 1
  }
}




