package com.example.matricescalculatorchallenge

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import com.bluelinelabs.conductor.Conductor
import com.bluelinelabs.conductor.Router
import com.bluelinelabs.conductor.RouterTransaction

/*Requirements
The goal of this application is to allow users to multiply matrices together and view the result on a separate page.

The requirements for this project are as follows:

Create a custom MainControllerMatrix class which will.
Store matrixes in a 2-dimentional array
This line Array(height) { Array(width) { 0 } } will declare an array of size height x width and fill it with 0s

Overload the * and index operators
This page will provide information on overloading the index operator (https://kotlinlang.org/docs/reference/operator-overloading.html)

Include height and width properties with setters that will resize your matrix data array when they're changed
To resize an array, you'll need to create a second array of the bigger size, copy the old array data to it, and then replace the property the value of the new array (=)

One controller which will show 2 matrices at once and a button to perform the calculation
The user must be able to edit the values in the matrices
Another controller which will show the result of the calculation as another matrix
You may have issues rebuilding your first controller after returning from your second one, a few tips:

Don't do controller interactions in onChangeEnded this triggers both when the controller is being created and another one is replacing it
If you use child controllers, be sure construct them with setPopsLastView(true) and to clear them with popCurrentController to allow you to rebuild them
Use by lazy and lateinit on class properties*/
class MainActivity : AppCompatActivity() {

//Conductor boilerplate
    lateinit var router: Router
    val container:ViewGroup by lazy {
        this.findViewById<ViewGroup>(R.id.activity_main_root)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        router = Conductor.attachRouter(this, container, savedInstanceState)
        if (!router.hasRootController()){
            router.setRoot(RouterTransaction.with(MainControllerMatrix()))
        }
    }
    override fun onBackPressed() {
        if (!router.handleBack())
            super.onBackPressed()
    }
}
