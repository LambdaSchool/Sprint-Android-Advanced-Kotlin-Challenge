package com.versilis.additionalandroidsprint

import java.util.*

class Matrix(private val x: Int,private val y: Int, val arrary: Array<Array<Int>>) {

    private var TwoDArray = Array(y) { Array(x) {0} }

    operator fun Matrix.times(other: Matrix): Matrix {
        val rows1 = this.x
        val cols1 = this.y
        val rows2 = other.x
        val cols2 = other.y
        require(cols1 == rows2)
       /* val result = Matrix(rows1) { Vector(cols2) }
        for (i in 0 until rows1) {
            for (j in 0 until cols2) {
                for (k in 0 until rows2) {
                    result[i][j] += this[i][k] * other[k][j]
                }
            }
        }*/
        return result
    }


}