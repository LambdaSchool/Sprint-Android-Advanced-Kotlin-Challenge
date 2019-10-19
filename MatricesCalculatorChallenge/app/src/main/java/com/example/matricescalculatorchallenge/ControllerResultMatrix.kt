package com.example.matricescalculatorchallenge

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.bluelinelabs.conductor.Controller
import com.bluelinelabs.conductor.ControllerChangeHandler
import com.bluelinelabs.conductor.ControllerChangeType
//This is where all your problems get displayed as solved but alas our problems are never solved
class ControllerResultMatrix(val bundle: Bundle): Controller() {

    override fun onChangeEnded(
        changeHandler: ControllerChangeHandler,
        changeType: ControllerChangeType
    ) {
        super.onChangeEnded(changeHandler, changeType)

        //receiving bundle
        val matrix = bundle.getSerializable("BUNDLE_KEY") as Matrix
        val result = matrix.myMatrix

        //instantiating views
        val tvAnswerRow1Column1 = view?.findViewById<TextView>(R.id.tv_row1_column1_cr)
        val tvAnswerRow1Column2 = view?.findViewById<TextView>(R.id.tv_row1_column2_cr)
        val tvAnswerRow2Column1 = view?.findViewById<TextView>(R.id.tv_row2_column1_cr)
        val tvAnswerRow2Column2 = view?.findViewById<TextView>(R.id.tv_row2_column2_cr)

        //Applying result
        tvAnswerRow1Column1?.text = result[0][0].toString()
        tvAnswerRow1Column2?.text = result[0][1].toString()
        tvAnswerRow2Column1?.text = result[1][0].toString()
        tvAnswerRow2Column2?.text = result[1][1].toString()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
        //inflating layoout
        val view = inflater.inflate(R.layout.controller_result, container, false)
        return view
    }

  /*  private fun result(matrix: Matrix){





    }*/
}