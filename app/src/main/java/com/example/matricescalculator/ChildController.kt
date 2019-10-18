package com.example.matricescalculator
import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.core.graphics.rotationMatrix
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.example.matricescalculator.MatrixFunctions.matrixMultiplication
import com.example.matricescalculator.MatrixFunctions.multiply
import kotlin.random.Random

class ChildController <T>(): BaseController()
    where T: Controller, T: ChildController.ChildContainer{



    constructor(targetController: T): this(){
        setTargetController(targetController)
    }

    interface ChildContainer{
        fun receiveResult(int: Int): Int {
            val mmatrix = multiply(arrayOf(arrayOf(1,2,3)), arrayOf(arrayOf(4,5,6))).toString().toInt()
            return mmatrix


        }

    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        return inflater.inflate(R.layout.activity_main, container, false)
    }
    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)
        val next = view?.findViewById<Button>(R.id.matrix)
        val result = view?.findViewById<TextView>(R.id.textView)

        next?.setText("MATRIX IT")
        next?.setOnClickListener {

            //todo 14
            (targetController as ChildContainer).receiveResult(Random.nextInt())
        }

    }

}