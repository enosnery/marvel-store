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
import com.enosnery.swissknife.R.drawable.*



import kotlinx.android.synthetic.main.activity_calculator.*

class CalculatorActivity : AppCompatActivity() {
    enum class OperationType{
        PLUS,
        MINUS,
        MULTIPLICATION,
        DIVISION,
        NULL
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
        val btnShowClear = Button(this)

        var firstValue = 0.0f
        var secondValue = 0.0f
        var total = 0.0f
        var operation: OperationType = OperationType.NULL
        var isSecondValue = false


        //endregion

        //region [LayoutParams]
        val layoutparams = ConstraintLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        layoutparams.setMargins(30,30,30,30)
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
        editparams.addRule(RelativeLayout.TEXT_ALIGNMENT_TEXT_END)
        editText.layoutParams = editparams
        editText.setText("%.2f".format(total))
        editText.focusable = EditText.NOT_FOCUSABLE
        editText.gravity = Gravity.END
        editText.setPadding(15,15,30,15)

        relative_calculator?.addView(editText)
        //endregion

        //region [Button 1]
        btnShow1.id = View.generateViewId()
        btnShow1.text = "1"
        val params1 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params1.addRule(RelativeLayout.BELOW, editText.id)
        btnShow1.layoutParams = params1
        btnShow1.setOnClickListener {
           checkZero("1", editText)
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
        btnShow2.setBackgroundResource(button_calc_number)
        btnShow2.setOnClickListener {
           checkZero("2", editText)
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
        btnShow3.setBackgroundResource(button_calc_number)
        btnShow3.setOnClickListener {
            checkZero("3", editText)
        }
        relative_calculator?.addView(btnShow3)
        //endregion Button 3

        //region [Button 4]
        btnShow4.id = View.generateViewId()
        val params4 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params4.addRule(RelativeLayout.BELOW, btnShow1.id)
        btnShow4.text = "4"
        btnShow4.layoutParams = params4
        btnShow4.setBackgroundResource(button_calc_number)
        btnShow4.setOnClickListener {
            checkZero("4", editText)
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
        btnShow5.setBackgroundResource(button_calc_number)
        btnShow5.setOnClickListener {
            checkZero("5", editText)
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
        btnShow6.setBackgroundResource(button_calc_number)
        btnShow6.setOnClickListener {
            checkZero("6", editText)
        }
        relative_calculator?.addView(btnShow6)
        //endregion Button 6

        //region [Button 7]
        btnShow7.id = View.generateViewId()
        val params7 = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        params7.addRule(RelativeLayout.BELOW, btnShow4.id)
        btnShow7.text = "7"
        btnShow7.layoutParams = params7
        btnShow7.setBackgroundResource(button_calc_number)
        btnShow7.setOnClickListener {
            checkZero("7", editText)
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
        btnShow8.setBackgroundResource(button_calc_number)
        btnShow8.setOnClickListener {
            checkZero("8", editText)
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
        btnShow9.setBackgroundResource(button_calc_number)
        btnShow9.setOnClickListener {
            checkZero("9", editText)
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
        btnShow0.setBackgroundResource(button_calc_number)
        btnShow0.setOnClickListener {
            checkZero("0", editText)
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
            if (isSecondValue) {
                secondValue = editText.text.toString().toFloat()
                total = when (operation.ordinal) {
                    0 -> firstValue + secondValue
                    1 -> firstValue - secondValue
                    2 -> firstValue * secondValue
                    3 -> firstValue / secondValue
                    else -> 0.0f
                }
                isSecondValue = false
                editText.setText("%.2f".format(total))
            }
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
            if(!isSecondValue) {
                if (!editText.text.toString().toFloat().equals(0.0f)) {
                    firstValue = editText.text.toString().toFloat()
                    operation = OperationType.PLUS
                    isSecondValue = true
                    editText.setText("%.2f".format(0f))
                }
            }
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

        //region [Button Clear]
        btnShowClear.id = View.generateViewId()
        val paramsClear = RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
        paramsClear.addRule(RelativeLayout.BELOW, btnShowDecimal.id)
        btnShowClear.text = "C"
        btnShowClear.layoutParams = paramsClear
        btnShowClear.setOnClickListener {
            editText.setText("0")
        }
        relative_calculator?.addView(btnShowClear)
        //endregion Button Clear

        //region [Button Styles]
        buttonStyleNumbers(btnShow0)
        buttonStyleNumbers(btnShow1)
        buttonStyleNumbers(btnShow2)
        buttonStyleNumbers(btnShow3)
        buttonStyleNumbers(btnShow4)
        buttonStyleNumbers(btnShow5)
        buttonStyleNumbers(btnShow6)
        buttonStyleNumbers(btnShow7)
        buttonStyleNumbers(btnShow8)
        buttonStyleNumbers(btnShow9)
        buttonStyleOperands(btnShowDecimal)
        buttonStyleOperands(btnShowEquals)
        buttonStyleOperands(btnShowPlus)
        buttonStyleOperands(btnShowMinus)
        buttonStyleOperands(btnShowDivision)
        buttonStyleOperands(btnShowTimes)
        //endregion

    }

    private fun buttonStyleNumbers(btn : Button?){
            btn?.setBackgroundResource(button_calc_number)
            btn?.setTextColor(Color.parseColor("#0B7000"))
            btn?.setShadowLayer(5f, 0f,0f,Color.parseColor("#A8A8A8"))
            btn?.textSize = 30f
    }

    private fun buttonStyleOperands(btn : Button?){
        btn?.setBackgroundResource(button_calc_number)
        btn?.setTextColor(Color.parseColor("#707070"))
        btn?.setShadowLayer(5f, 0f,0f,Color.parseColor("#A8A8A8"))
        btn?.textSize = 30f
    }

    private fun checkZero(value: String?, editText: EditText?){
        var temp = editText?.text.toString()
        if(temp.length < 10) {
            if (temp.toFloat() != 0.00f) {
                temp += value
                editText?.setText(temp)
            } else {
                editText?.setText(value)
            }
        }
    }

}