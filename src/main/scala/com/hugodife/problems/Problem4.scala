package com.hugodife.problems

object Problem4 {

  val min7GroupIntervalLength = 3
  val min7GroupIntervalLengthExclusive = min7GroupIntervalLength + 1
  val max7GroupIntervals = 6

  val price1D = 2
  val price7D = 7
  val price30D = 25

  def solution(a: Array[Int]): Int = {
    if(a.length == 0) return 0
    val intervals = a.sliding(2).map{ case Array(first, second) => second - first }.toArray
    (0 to intervals.length)
      .map(slice => computeValue(slice * price1D, intervals.drop(slice)))
      .min
  }

  def computeValue(acc: Int, intervals: Array[Int]): Int = {
    if(intervals.length == 0) return 0
    if(acc >= price30D) return price30D
    val groupIndex = first7DayGroupIndex(intervals).getOrElse(return acc + intervals.length * 2)
    val groupEndIndex = groupIndex + endIndexOf7DayGroup(intervals.drop(groupIndex))
    (groupEndIndex to intervals.length)
      .map(slice => {
        val previousBeforeGroup = groupIndex * price1D
        val priceAfterGroup = (slice - groupEndIndex) * price1D
        computeValue(price7D + previousBeforeGroup + priceAfterGroup, intervals.drop(slice))
      }).min
  }

  def first7DayGroupIndex(intervals: Array[Int]): Option[Int] = {
    //isGroup if min 3 intervals and max == 6
    for(i <- 0 to (intervals.length - 3)) {
      if(intervals.slice(i, min7GroupIntervalLengthExclusive).sum <= max7GroupIntervals)
        return Some(i)
    }
    None
  }

  def endIndexOf7DayGroup(intervals: Array[Int]): Int = {
    var index = min7GroupIntervalLength
    var intervalSum = intervals.slice(0, min7GroupIntervalLengthExclusive).sum
    for(interval <- intervals.slice(min7GroupIntervalLengthExclusive, intervals.length)) {
      intervalSum += interval
      if(intervalSum > max7GroupIntervals)
        return index
      else
        index += 1
    }
    index
  }
}




