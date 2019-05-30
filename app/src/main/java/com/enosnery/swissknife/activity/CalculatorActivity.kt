package com.enosnery.swissknife.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.InputType
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
        val btnShow7 = Button(this)
        val btnShow8 = Button(this)
        val btnShow9 = Button(this)
        val btnShowDecimal = Button(this)
        val btnShow0 = Button(this)
        val btnShowEquals = Button(this)
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
        editText.focusable = EditText.NOT_FOCUSABLE
        editText.inputType = InputType.TYPE_CLASS_NUMBER

        relative_calculator?.addView(editText)

        //Button 1
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
        relative_calculator?.addView(btnShow1)
        //END Button 1

        //Button 2
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
        relative_calculator?.addView(btnShow2)
        //END Button 2

        //Button 3
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
        relative_calculator?.addView(btnShow3)
        //END Button 3

        //Button 4
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
        relative_calculator?.addView(btnShow4)
        //END Button 4

        //Button 5
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
        relative_calculator?.addView(btnShow5)
        //END Button 5

        //Button 6
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
        relative_calculator?.addView(btnShow6)
        //END Button 6

        //Button 7
        btnShow7.id = View.generateViewId()
        val params7 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params7.addRule(RelativeLayout.BELOW, btnShow4.id)
        btnShow7.text = "7"
        btnShow7.layoutParams = params7
        btnShow7.setOnClickListener {
            var inner = editText.text.toString()
            inner += "7"
            editText.setText(inner)
        }
        relative_calculator?.addView(btnShow7)
        //END Button 7

        //Button 8
        btnShow8.id = View.generateViewId()
        val params8 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params8.addRule(RelativeLayout.RIGHT_OF, btnShow7.id)
        params8.addRule(RelativeLayout.BELOW, btnShow5.id)
        btnShow8.text = "8"
        btnShow8.layoutParams = params8
        btnShow8.setOnClickListener {
            var inner = editText.text.toString()
            inner += "8"
            editText.setText(inner)
        }
        relative_calculator?.addView(btnShow8)
        //END Button 8

        //Button 9
        btnShow9.id = View.generateViewId()
        val params9 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params9.addRule(RelativeLayout.RIGHT_OF, btnShow8.id)
        params9.addRule(RelativeLayout.BELOW, btnShow6.id)
        btnShow9.text = "9"
        btnShow9.layoutParams = params9
        btnShow9.setOnClickListener {
            var inner = editText.text.toString()
            inner += "9"
            editText.setText(inner)
        }
        relative_calculator?.addView(btnShow9)
        //END Button 9
        
        //Button Decimal
        btnShowDecimal.id = View.generateViewId()
        val paramsDecimal = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsDecimal.addRule(RelativeLayout.BELOW, btnShow7.id)
        btnShowDecimal.text = "."
        btnShowDecimal.layoutParams = paramsDecimal
        btnShowDecimal.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowDecimal)
        //END Button Decimal
        
        //Button 0
        btnShow0.id = View.generateViewId()
        val params0 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params0.addRule(RelativeLayout.RIGHT_OF, btnShowDecimal.id)
        params0.addRule(RelativeLayout.BELOW, btnShow8.id)
        btnShow0.text = "0"
        btnShow0.layoutParams = params0
        btnShow0.setOnClickListener {
            var inner = editText.text.toString()
            if (inner != "") {
                inner += "0"
            editText.setText(inner)
            }else if (inner == "0" || inner == ""){
                editText.text = null
                inner = "0"
                editText.setText(inner)
            }
        }
        relative_calculator?.addView(btnShow0)
        //END Button 0
        
        //Button Equals
        btnShowEquals.id = View.generateViewId()
        val paramsEquals = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsEquals.addRule(RelativeLayout.RIGHT_OF, btnShow0.id)
        paramsEquals.addRule(RelativeLayout.BELOW, btnShow9.id)
        btnShowEquals.text = "="
        btnShowEquals.layoutParams = paramsEquals
        btnShowEquals.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowEquals)
        //END Button Equals

    }

}