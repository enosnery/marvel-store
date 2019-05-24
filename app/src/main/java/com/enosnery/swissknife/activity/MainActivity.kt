package com.enosnery.swissknife.activity

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.enosnery.swissknife.R
import com.enosnery.swissknife.R.string.*
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main.text = getString(app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10,10,10,10)
        button_main.text = getString(open_calculator)
        button_main.setOnClickListener {
            startActivity(Intent(this,CalculatorActivity::class.java))
        }

    }
}
