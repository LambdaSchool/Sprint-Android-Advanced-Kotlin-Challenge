package com.example.matricescalculatorchallenge

import java.io.Serializable

class Matrix(var myMatrix: Array<Array<Int>>) : Serializable{
    //Ok so time to go look up matrix calculations haven't done these since school
    fun multiply(n: Matrix):Matrix{
        //I know I should have made it row 0 instead of 1
        //row 1 column 1 multipled by entered matrix row 1 column 1 then row 1 column 2 multiplied by row 2 column 1 summed
        val row1col1 = (myMatrix[0][0] * n.myMatrix[0][0]) + (myMatrix[0][1] * n.myMatrix[1][0])
        //////////////////
        val row1col2  = (myMatrix[0][0] * n.myMatrix[0][1]) + (myMatrix[0][1] * n.myMatrix[1][1])
        val row2col1  = (myMatrix[1][0] * n.myMatrix[0][0]) + (myMatrix[1][1] * n.myMatrix[1][0])
        val row2col2  = (myMatrix[1][0] * n.myMatrix[0][1]) + (myMatrix[1][1] * n.myMatrix[1][1])

        //Chances matrix setup
        val matrix = Matrix(Array(2) { Array(2) { 0 } })

        return matrix
    }

}