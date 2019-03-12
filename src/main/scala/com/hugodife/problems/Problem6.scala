package com.hugodife.problems

object Problem6 {

  case class Cord(x: Int, y: Int) {
    def addX(amount: Int) = Cord(x + amount, y)
    def addY(amount: Int) = Cord(x, y + amount)
    def substractX(amount: Int) = addX(-amount)
    def substractY(amount: Int) = addY(-amount)
    def moveRigth() = addX(1)
    def moveBot() = addY(1)
  }

  case class Matrix(values: Map[Cord, Boolean], n: Int, m: Int) {
    def get(cord: Cord) = values.get(cord)
    def isEnd(cord: Cord) = cord.x == (n - 1) && cord.y == (m - 1)
    def minLength = n min m
  }

  def solution(a: Array[Array[Boolean]]): Int = {
    if(!a(a.length - 1)(a(0).length - 1)) return 0
    val matrixValues = a.zipWithIndex
      .flatMap{ case(row, indexR) =>
        row.zipWithIndex
          .map{ case(element, indexC) => Cord(indexC, indexR) -> element}}.toMap

    val matrix = Matrix(matrixValues, a(0).length, a.length)
    (matrix.minLength to 1 by -1).toArray
      .filter(squareSize => isValidInitialSquare(squareSize, a))
      .find(squareSize => canTravelToEnd(Cord(squareSize - 1, squareSize - 1), squareSize, matrix))
      .getOrElse(0)
  }

  def canTravelToEnd(cordBotRigth: Cord, squareSize: Int, matrix: Matrix): Boolean = {

    def isValidCurrentMov(): Boolean = {
      generateSquareCorner(cordBotRigth, squareSize)
        .map(matrix.get)
        .map(_.getOrElse(false))
        .reduce(_ && _)
    }

    if(!isValidCurrentMov()) false
    else if(matrix.isEnd(cordBotRigth)) true
    else canTravelToEnd(cordBotRigth.moveRigth(), squareSize, matrix) ||
        canTravelToEnd(cordBotRigth.moveBot(), squareSize, matrix)
  }

  def isValidInitialSquare(size: Int, matrix: Array[Array[Boolean]]) = {
    matrix.slice(0, size).map(row => row.slice(0, size).reduce(_ && _)).reduce(_ & _)
  }

  def generateSquareCorner(cordBottomRigth: Cord, squareSize: Int): Array[Cord] = {
    (0 until squareSize).map(cordBottomRigth.substractX).toArray ++
      (0 until squareSize).map(cordBottomRigth.substractY)
  }
}
