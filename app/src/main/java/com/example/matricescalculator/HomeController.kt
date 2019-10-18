package com.example.matricescalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
import com.bluelinelabs.conductor.RouterTransaction
import com.bluelinelabs.conductor.changehandler.HorizontalChangeHandler
import kotlinx.android.synthetic.main.activity_main.view.*


class HomeController(var message: String? = null) : BaseController(), ChildController.ChildContainer {

    override fun receiveResult(int: Int): Int {
        message = message?.plus("$int")
        view?.findViewById<TextView>(R.id.textView)?.text = message ?: "Matrix is\n$int"
        return int
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        val view = inflater.inflate(R.layout.activity_main, container, false)
        val etA11 = view.one.text.toString()
        val etA12 = view.two.text.toString()
        val etA21 = view.three.text.toString()
        val etA22 = view.four.text.toString()
        val etB11 = view.five.text.toString()
        val etB12 = view.six.text.toString()
        val etB21 = view.seven.text.toString()
        val etB22 = view.eight.text.toString()

        return view
    }

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        //todo 7 button next
        view?.findViewById<Button>(R.id.matrix)?.setOnClickListener {
            //todo 8
            router.pushController(
                RouterTransaction.with(ChildController(this))
                    .pushChangeHandler(HorizontalChangeHandler())
                    .popChangeHandler(HorizontalChangeHandler())
            )

        }
    }
}