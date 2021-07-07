package com.example.matricescalculator

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.marginBottom
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.view.*



class HomeController: Controller {


    constructor() : super()

    constructor(args: Bundle?) : super(args)


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {

        val view = inflater.inflate(R.layout.activity_main, container, false)

        view.matrixButton.setOnClickListener {
            Matrix.height = 3
            Matrix.width2 = 3
            Matrix.width = 3
            Matrix.height2 = 3
            val matrix = matrix(Matrix.height, Matrix.width)


            matrix.set(0, 0, view.one.getNumber())
            matrix[0][1] = view.two.getNumber()
            matrix[1][0] = view.three.getNumber()
            matrix[1][1] = view.four.getNumber()

            matrix.forEach {
                it.forEach {
                    println(it)
                }
            }


            val matrix2 = matrix(Matrix.height2, Matrix.width2)
            matrix2[0][0] = view.five.getNumber()
            matrix2[0][1] = view.six.getNumber()
            matrix2[1][0] = view.seven.getNumber()
            matrix2[1][1] = view.eight.getNumber()

            if (Matrix.width == Matrix.height2) {

                val finalProduct = matrix.times(matrix2)
                args.putStringArrayList(MainActivity.BUNDLE_KEY, finalProduct)

                router.pushController(
                    RouterTransaction.with(ChildController(args))
                        .pushChangeHandler(HorizontalChangeHandler())
                        .popChangeHandler(HorizontalChangeHandler()))
            } else {
                val alert =
                    "The number of columns in the first matrix should be equal to the number of rows in the second."
                Toast.makeText(view.context, alert, Toast.LENGTH_LONG).show()
            }
        }
        return view
    }
}