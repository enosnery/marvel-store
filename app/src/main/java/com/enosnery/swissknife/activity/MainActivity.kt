package com.enosnery.swissknife.activity

import android.app.ActionBar
import android.content.DialogInterface
import android.content.Intent
import android.graphics.Color
import android.graphics.Matrix
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.support.v7.app.AlertDialog
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.Toast
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
                val intent = Intent(this, CalculatorActivity::class.java).apply {
                    putExtra(EXTRA_MESSAGE, getString(app_name))
                }
            startActivity(intent)

        }

        main_relative.gravity = RelativeLayout.ALIGN_PARENT_RIGHT

    }

    fun showDialog() {
        super.onDestroy()
        val builder = AlertDialog.Builder(this@MainActivity)
        builder.setMessage(exit_message)
        builder.setNegativeButton(no){ _, _ ->
            Toast.makeText(applicationContext, "Ok, awesome! How may I help you?", Toast.LENGTH_LONG).show()
        }
        builder.setPositiveButton(yes){ _, _ ->
            this@MainActivity.finishAndRemoveTask()
        }
        builder.setNeutralButton(maybe){ _,_ ->
            Toast.makeText(applicationContext, "Err...what?", Toast.LENGTH_LONG).show()
        }
        val dialog : AlertDialog = builder.create()

        dialog.show()
    }

}

