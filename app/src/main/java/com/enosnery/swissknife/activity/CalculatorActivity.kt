package com.enosnery.swissknife.activity

import android.content.Context
import android.graphics.Color
import android.os.Bundle
import android.support.constraint.ConstraintLayout
import android.support.v4.content.Loader
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
    enum class operationType{
        PLUS,
        MINUS,
        MULTIPLICATION,
        DIVISION
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_calculator)

        //region [Variables Declaration]
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
        val btnShowPlus = Button(this)
        val btnShowMinus = Button(this)
        val btnShowTimes = Button(this)
        val btnShowDivision = Button(this)

        var firstValue: Float
        var secondValue: Float
        var total: Float
        var operation: operationType


        //endregion

        //region [LayoutParams]
        val layoutparams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layoutparams.setMargins(10,20,10,10)
        relativeLayout.layoutParams = layoutparams
        //endregion

        //region [Back Button]
        val backparams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        backparams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM)
        button_calculator.layoutParams = backparams
        button_calculator.text = getString(go_back)
        button_calculator.setTextColor(Color.BLACK)
        button_calculator.setOnClickListener {

            finish()
        }
        //endregion

        //region [EditText]
        editText.id = View.generateViewId()
        val editparams = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        editparams.addRule(RelativeLayout.ALIGN_RIGHT)
        editText.layoutParams = editparams
        editText.setText("0")
        editText.focusable = EditText.NOT_FOCUSABLE
        editText.inputType = InputType.TYPE_CLASS_NUMBER

        relative_calculator?.addView(editText)
        //endregion

        //region [Button 1]
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
        //endregion Button 1

        //region [Button 2]
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
        //endregion Button 2

        //region [Button 3]
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
        //endregion Button 3

        //region [Button 4]
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
        //endregion Button 4

        //region [Button 5]
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
        //endregion Button 5

        //region [Button 6]
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
        //endregion Button 6

        //region [Button 7]
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
        //endregion Button 7

        //region [Button 8]
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
        //endregion Button 8

        //region [Button 9]
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
        //endregion Button 9
        
        //region [Button Decimal]
        btnShowDecimal.id = View.generateViewId()
        val paramsDecimal = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsDecimal.addRule(RelativeLayout.BELOW, btnShow7.id)
        btnShowDecimal.text = "."
        btnShowDecimal.layoutParams = paramsDecimal
        btnShowDecimal.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowDecimal)
        //endregion Button Decimal
        
        //region [Button 0]
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
        //endregion Button 0
        
        //region [Button Equals]
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
        //endregion Button Equals

        //region [Button Plus]
        btnShowPlus.id = View.generateViewId()
        val paramsPlus = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsPlus.addRule(RelativeLayout.RIGHT_OF, btnShow3.id)
        paramsPlus.addRule(RelativeLayout.BELOW, editText.id)
        btnShowPlus.text = "+"
        btnShowPlus.layoutParams = paramsPlus
        btnShowPlus.setOnClickListener {
            firstValue = editText.text.toString().toFloat()
            operation = operationType.PLUS
        }
        relative_calculator?.addView(btnShowPlus)
        //endregion Button Plus

        //region [Button Minus]
        btnShowMinus.id = View.generateViewId()
        val paramsMinus = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsMinus.addRule(RelativeLayout.RIGHT_OF, btnShow6.id)
        paramsMinus.addRule(RelativeLayout.BELOW, btnShowPlus.id)
        btnShowMinus.text = "-"
        btnShowMinus.layoutParams = paramsMinus
        btnShowMinus.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowMinus)
        //endregion Button Minus

        //region [Button Multiplication]
        btnShowTimes.id = View.generateViewId()
        val paramsTimes = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsTimes.addRule(RelativeLayout.RIGHT_OF, btnShow9.id)
        paramsTimes.addRule(RelativeLayout.BELOW, btnShowMinus.id)
        btnShowTimes.text = "*"
        btnShowTimes.layoutParams = paramsTimes
        btnShowTimes.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowTimes)
        //endregion Button Multiplication

        //region [Button Division]
        btnShowDivision.id = View.generateViewId()
        val paramsDivision = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsDivision.addRule(RelativeLayout.RIGHT_OF, btnShowEquals.id)
        paramsDivision.addRule(RelativeLayout.BELOW, btnShowTimes.id)
        btnShowDivision.text = "/"
        btnShowDivision.layoutParams = paramsDivision
        btnShowDivision.setOnClickListener {
            Toast.makeText(this,"Não implementado :(", Toast.LENGTH_SHORT).show()
        }
        relative_calculator?.addView(btnShowDivision)
        //endregion Button Division

    }

}