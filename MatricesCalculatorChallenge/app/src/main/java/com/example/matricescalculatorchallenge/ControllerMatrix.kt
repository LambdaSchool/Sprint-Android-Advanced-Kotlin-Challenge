package com.example.matricescalculatorchallenge

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bluelinelabs.conductor.Controller

class ControllerMatrix: Controller() {
  override fun onCreateView(inflater: LayoutInflater, container: ViewGroup): View {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  var array = Array(4) { Array(4) { 0 } }
}