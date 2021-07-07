package com.example.matricescalculator

import android.widget.EditText


fun EditText.getNumber(): Int {
    return text.toString().toInt()

}