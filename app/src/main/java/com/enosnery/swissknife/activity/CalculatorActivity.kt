package com.enosnery.swissknife.activity

import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.view.Gravity
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.RelativeLayout
import android.widget.Toast
import com.enosnery.swissknife.R.string.*
import com.enosnery.swissknife.R.layout.*


import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_calculator)
        val relativeLayout = relative_calculator
        val editText = EditText(this)
        val btnShow1 = Button(this)
        val btnShow2 = Button(this)
        val btnShow3 = Button(this)
        val btnShow4 = Button(this)
        val btnShow5 = Button(this)
        val btnShow6 = Button(this)
        val layoutparams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layoutparams.setMargins(10,20,10,10)
        relativeLayout.layoutParams = layoutparams

        val backparams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        backparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        button_calculator.layoutParams = backparams
        button_calculator.text = getString(go_back)
        button_calculator.setTextColor(Color.BLACK)
        button_calculator.setOnClickListener {

            finish()
        }

        editText.id = View.generateViewId()
        val editparams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        editparams.addRule(RelativeLayout.ALIGN_RIGHT)
        editText.layoutParams = editparams
        editText.inputType = EditText.NOT_FOCUSABLE

        relative_calculator?.addView(editText)
        // Create Button Dynamically

        btnShow1.id = View.generateViewId()
        btnShow1.text = "1"
        val params1 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params1.addRule(RelativeLayout.BELOW, editText.id)
        btnShow1.layoutParams = params1
        btnShow1.setOnClickListener {
            var inner = editText.text.toString()
            inner += "1"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow1)

        btnShow2.id = View.generateViewId()
        val params2 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params2.addRule(RelativeLayout.BELOW, editText.id)
        params2.addRule(RelativeLayout.RIGHT_OF, btnShow1.id)
        btnShow2.text = "2"
        btnShow2.layoutParams = params2
        btnShow2.setOnClickListener {
            var inner = editText.text.toString()
            inner += "2"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow2)

        btnShow3.id = View.generateViewId()
        val params3 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params3.addRule(RelativeLayout.RIGHT_OF, btnShow2.id)
        params3.addRule(RelativeLayout.BELOW, editText.id)
        btnShow3.text = "3"
        btnShow3.layoutParams = params3
        btnShow3.setOnClickListener {
            var inner = editText.text.toString()
            inner += "3"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow3)


        btnShow4.id = View.generateViewId()
        val params4 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params4.addRule(RelativeLayout.BELOW, btnShow1.id)
        btnShow4.text = "4"
        btnShow4.layoutParams = params4
        btnShow4.setOnClickListener {
            var inner = editText.text.toString()
            inner += "4"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow4)



        btnShow5.id = View.generateViewId()
        val params5 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params5.addRule(RelativeLayout.RIGHT_OF, btnShow4.id)
        params5.addRule(RelativeLayout.BELOW, btnShow2.id)
        btnShow5.text = "5"
        btnShow5.layoutParams = params5
        btnShow5.setOnClickListener {
            var inner = editText.text.toString()
            inner += "5"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow5)

        btnShow6.id = View.generateViewId()
        val params6 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params6.addRule(RelativeLayout.RIGHT_OF, btnShow5.id)
        params6.addRule(RelativeLayout.BELOW, btnShow3.id)
        btnShow6.text = "6"
        btnShow6.layoutParams = params6
        btnShow6.setOnClickListener {
            var inner = editText.text.toString()
            inner += "6"
            editText.setText(inner)
        }

        // Add Button to LinearLayout
        relative_calculator?.addView(btnShow6)
    }

}