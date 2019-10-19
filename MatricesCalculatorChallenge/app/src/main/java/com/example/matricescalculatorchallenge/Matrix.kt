package com.example.matricescalculatorchallenge

import java.io.Serializable

class Matrix(var myMatrix: Array<IntArray>, var matrixHeight: Int, var matrixWidth: Int) :Serializable {


    //Ok so time to go look up matrix calculations haven't done these since school

        //I know I should have made it row 0 instead of 1
        //row 1 column 1 multipled by entered matrix row 1 column 1 then row 1 column 2 multiplied by row 2 column 1 summed
        /*  val row1col1 = (myMatrix[0][0] * n.myMatrix[0][0]) + (myMatrix[0][1] * n.myMatrix[1][0])
        //////////////////
        val row1col2  = (myMatrix[0][0] * n.myMatrix[0][1]) + (myMatrix[0][1] * n.myMatrix[1][1])
        val row2col1  = (myMatrix[1][0] * n.myMatrix[0][0]) + (myMatrix[1][1] * n.myMatrix[1][0])
        val row2col2  = (myMatrix[1][0] * n.myMatrix[0][1]) + (myMatrix[1][1] * n.myMatrix[1][1])

        //Chances matrix setup
        val matrix = Matrix(Array(2) { Array(2) { 0 } })*/

    //Strange connection to multiple I kind of remember chance talking about this
    operator fun times(matrix: Matrix): Matrix {

        //passed in matrix
        val matrix1 = myMatrix
        //obviously matrix2
        val matrix2 = matrix.myMatrix

        val row1 = matrixWidth
        val column1 = matrixHeight
        val column2 = matrix.matrixWidth

        //iteration through the rows and columns then performs relevant calculations
        //Confession, taken from https://www.programiz.com/kotlin-programming/examples/multiply-matrix
        val answers = Matrix(Array(row1){IntArray(column2)}, matrixHeight, matrix.matrixWidth)
        for (i in 0..row1 - 1){
            for (x in 0..column2-1){
                for (j in 0..column1-1){
                    answers.myMatrix[i][x] += matrix1[i][j] * matrix2[j][x]
                }

            }

        }

        //Hmm I wonder what this does
        return answers
    }


}

