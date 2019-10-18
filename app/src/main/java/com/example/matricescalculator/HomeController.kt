package com.example.matricescalculator

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller
import kotlinx.android.synthetic.main.activity_main.view.*


class HomeController : Controller() {

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

}