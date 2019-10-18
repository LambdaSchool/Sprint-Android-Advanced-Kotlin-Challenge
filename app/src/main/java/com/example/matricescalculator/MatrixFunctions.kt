package com.example.matricescalculator

import java.io.Serializable

class MatrixFunctions{

    fun matrixMultiplication() {

        val matrixA = arrayOf(

            arrayOf(1, 2, 3),
            arrayOf(4, 5, 6)
        )

        val matrixB = arrayOf(

            arrayOf(7,   8),
            arrayOf(9,  10),
            arrayOf(11, 12)
        )

        println ("Matrix A")
        prettyPrintMatrix( matrixA )

        println()

        println ("Matrix B")
        prettyPrintMatrix( matrixB )

        println()

        println ("Multiplication of Matrix A * Matrix B")
        val res = multiply(matrixA, matrixB)
        prettyPrintMatrix( res )
    }

    private fun prettyPrintMatrix( matrix: Array<Array<Int>> ) {

        for ( array in matrix ) {

            println( array.joinToString { x -> x.toString() + " " })
        }
    }

    private fun multiply( ma: Array<Array<Int>>, mb: Array<Array<Int>> ): Array<Array<Int>> {

        val result = Array(ma.size, { Array(mb[0].size, {0} ) })

        for ( i in result.indices)

            for ( j in ma.indices)

                for ( k in ma[0].indices)

                    result[i][j] += ma[i][k] * mb[k][j]

        return result
    }

}