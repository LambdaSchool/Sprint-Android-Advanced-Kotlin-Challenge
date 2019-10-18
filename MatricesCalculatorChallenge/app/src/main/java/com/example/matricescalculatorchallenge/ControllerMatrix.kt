package com.example.matricescalculatorchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

class ControllerMatrix: Controller() {


  var array = Array(2) { Array(2) { 0 } }
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    val view = inflater.inflate(R.layout.main_controller_matrix_layout, container, false)
    return view
  }

}