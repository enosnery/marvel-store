package com.enosnery.swissknife.activity

import android.graphics.Color
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import com.enosnery.swissknife.R.string.*
import com.enosnery.swissknife.R.layout.activity_calculator

import kotlinx.android.synthetic.main.activity_calculator.*
import kotlinx.android.synthetic.main.activity_main.*

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)
        setContentView(activity_calculator)
        text_calculator.text = getString(welcome_calculator)
        text_calculator.setTextColor(Color.WHITE)
        text_calculator.setBackgroundColor(Color.RED)
        button_calculator.text = getString(go_back)
        button_calculator.gravity = (Gravity.BOTTOM)
        button_calculator.setOnClickListener {
            finish()
        }
    }

}