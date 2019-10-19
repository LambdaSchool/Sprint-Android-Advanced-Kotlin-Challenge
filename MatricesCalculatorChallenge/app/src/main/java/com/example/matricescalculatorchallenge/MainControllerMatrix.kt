package com.example.matricescalculatorchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction

class MainControllerMatrix : Controller() {


    lateinit var matrixMultiply: Matrix

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.main_controller_matrix_layout, container, false)
        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType


    ) {


       // matrixViews()
        super.onChangeEnded(changeHandler, changeType)

        val button = view?.findViewById<Button>(R.id.button_multiply)
        button?.setOnClickListener {
            //matrixViews()

            val bundle = Bundle()

            val etM1R1C1 = view?.findViewById<EditText>(R.id.et_r1_c1)
            val etM1R1C2 = view?.findViewById<EditText>(R.id.et_r1_c2)
            val etM1R2C1 = view?.findViewById<EditText>(R.id.et_r2_c1)
            val etM1R2C2 = view?.findViewById<EditText>(R.id.et_r2_c2)

            val etM2R1C1 = view?.findViewById<EditText>(R.id.et_bottom_r1_c1)
            val etM2R1C2 = view?.findViewById<EditText>(R.id.et_bottom_r1_c2)
            val etM2R2C1 = view?.findViewById<EditText>(R.id.et_bottom_r2_c1)
            val etM2R2C2 = view?.findViewById<EditText>(R.id.et_bottom_r2_c2)


            //There has to be a better way
            val matrix1Row1Column1 = etM1R1C1?.text.toString()
            val matrix1Row1Column2 = etM1R1C2?.text.toString()
            val matrix1Row2Column1 = etM1R2C1?.text.toString()
            val matrix1Row2Column2 = etM1R2C2?.text.toString()


            val matrix2Row1Column1 = etM2R1C1?.text.toString()
            val matrix2Row1Column2 = etM2R1C2?.text.toString()
            val matrix2Row2Column1 = etM2R2C1?.text.toString()
            val matrix2Row2Column2 = etM2R2C2?.text.toString()

            val matrixOne = Matrix(Array(2) { IntArray(2) { 0 } }, 2, 2)
            val matrixTwo = Matrix(Array(2) { IntArray(2) { 0 } }, 2, 2)

            // I wish I could abstract all this away but honestly it is to late and my brain no work good
            matrixOne.myMatrix[0][0] = matrix1Row1Column1.toInt()
            matrixOne.myMatrix[0][1] = matrix1Row1Column2.toInt()
            matrixOne.myMatrix[0][0] = matrix1Row2Column1.toInt()
            matrixOne.myMatrix[0][0] = matrix1Row2Column2.toInt()

            matrixTwo.myMatrix[0][0] = matrix2Row1Column1.toInt()
            matrixTwo.myMatrix[0][0] = matrix2Row1Column2.toInt()
            matrixTwo.myMatrix[0][0] = matrix2Row2Column1.toInt()
            matrixTwo.myMatrix[0][0] = matrix2Row2Column2.toInt()


            //could multiply without enabling that weird times function
            matrixMultiply = matrixOne * matrixTwo

            //passes bundle to relevant Controller
            bundle.putSerializable("BUNDLE_KEY", matrixMultiply)
            router.pushController(RouterTransaction.with(ControllerResultMatrix(bundle)))


        }


    }

   /* private fun matrixViews() {

    }*/

}