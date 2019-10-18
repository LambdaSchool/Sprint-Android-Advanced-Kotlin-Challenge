package com.example.matricescalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.marginBottom
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.view.*


class HomeController(var message: String? = null) : BaseController() {



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)


        view.matrixButton.setOnClickListener {
            Matrix.height = 2
            Matrix.width = 2

            val matrix = matrix(Matrix.height, Matrix.width)
            matrix.set(0,0, view.one.getNumber())
            matrix[0][1] = view.two.getNumber()
            matrix[1][0] = view.three.getNumber()
            matrix[1][1] = view.four.getNumber()

            val matrix2 = Matrix.matrix2
            matrix2[0][0] = view.five.getNumber()
            matrix2[0][1] = view.six.getNumber()
            matrix2[1][0] = view.seven.getNumber()
            matrix2[1][1] = view.eight.getNumber()

            val finalProduct = matrix.times(matrix2)
            args.putStringArrayList(MainActivity.BUNDLE_KEY, finalProduct)

            router.pushController(RouterTransaction.with(ChildController(args))
                .pushChangeHandler(HorizontalChangeHandler())
                .popChangeHandler(HorizontalChangeHandler())
            )
        }

        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        //todo 7 button next
        view?.findViewById<Button>(R.id.matrixButton)?.setOnClickListener {
            //todo 8
            router.pushController(
                RouterTransaction.with(ChildController())
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )

        }
    }
}