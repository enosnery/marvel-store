package com.enosnery.swissknife.activity

import adapters.ComicsAdapter
import android.app.ActionBar
import android.content.Context
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
import classes.Comic
import com.enosnery.swissknife.R
import com.enosnery.swissknife.R.string.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.apache.commons.codec.digest.DigestUtils
import org.json.JSONObject
import utils.ComicUtils
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text_main_container.setBackgroundColor(Color.BLACK)
        text_main.text = getString(app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10,10,10,10)
        run(this)
    }

    fun run(context : Context) {
        val ts = System.currentTimeMillis().toString()
        val hash = DigestUtils.md5Hex(ts+"e5292934cda4a6c0f400eea657f48592ab32e6fe"+"c902c557127a2121a4b90fe59bc8d4a0")
        val url = "https://gateway.marvel.com:443/v1/public/comics?noVariants=true&dateDescriptor=lastWeek&ts=$ts&apikey=c902c557127a2121a4b90fe59bc8d4a0&hash=$hash"
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body()?.string()
                val comicsList = ComicUtils.prepareArray(responseData)
                val adapter = ComicsAdapter(context, comicsList as ArrayList<Comic>)
                runOnUiThread {
                    comics_list_view.adapter = adapter
                }

            }
        })
    }
}

