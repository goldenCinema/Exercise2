package com.example.exercise2

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.view.View
import kotlin.math.round
import android.widget.EditText
import androidx.annotation.IdRes
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.buttonCalculate).setOnClickListener{
            BMI()
        }
        findViewById<Button>(R.id.buttonReset).setOnClickListener{
            clear()
        }
}

fun <T : View> Activity.bind(@IdRes res : Int) : Lazy<T> {
    @Suppress("UNCHECKED_CAST")
    return lazy { findViewById(res) as T }
}

private fun BMI(){
    var weight : Float = editTextWeight.text.toString().toFloat()
    var height : Float = editTextHeight.text.toString().toFloat()

    height = height / 100

    var bmi : Float = weight / (height*height)


    if(bmi < 18.5)
    {
        imageViewProfile.setImageResource(R.drawable.under)
        textViewBMI.setText(bmi.toString())
    }

    else if (bmi >= 18.5 && bmi <= 24.9)
    {
        imageViewProfile.setImageResource(R.drawable.normal)
        textViewBMI.setText(bmi.toString())
    }
    else if (bmi > 25)
    {
        imageViewProfile.setImageResource(R.drawable.over)
        textViewBMI.setText(bmi.toString())
    }

}
    private fun clear(){
        editTextHeight.setText("")
        editTextWeight.setText("")
        imageViewProfile.setImageResource(R.drawable.empty)
        textViewBMI.setText("")
    }
}
