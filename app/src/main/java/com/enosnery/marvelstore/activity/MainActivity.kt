package com.enosnery.marvelstore.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.string.app_name
import com.enosnery.marvelstore.adapters.ComicsAdapter
import com.enosnery.marvelstore.classes.Comic
import com.enosnery.marvelstore.utils.ComicUtils
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.apache.commons.codec.binary.Hex
import org.apache.commons.codec.digest.DigestUtils
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    val context = this
    lateinit var adapter: ComicsAdapter
    lateinit var comicsList : MutableList<Comic>

    companion object {
        const val EXTRA_IS_FINISHED = "comic"

        fun newIntent(context: Context, finished: Boolean): Intent {
            val detailIntent = Intent(context, MainActivity::class.java)
            detailIntent.putExtra(EXTRA_IS_FINISHED, finished)
            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(intent != null) {
            if(intent.extras != null) {
                val finished = intent.extras.getBoolean(EXTRA_IS_FINISHED)
                if (finished) {
                    Toast.makeText(context, "Checkout Finished!", Toast.LENGTH_SHORT).show()
                }
            }
        }
        text_main_container.setBackgroundColor(Color.BLACK)
        text_main.text = getString(app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10, 10, 10, 10)
        val ts = System.currentTimeMillis().toString()
        val hash = String(Hex.encodeHex(DigestUtils.md5(ts + "e5292934cda4a6c0f400eea657f48592ab32e6fe" + "c902c557127a2121a4b90fe59bc8d4a0")))
        val url = "https://gateway.marvel.com:443/v1/public/comics?noVariants=true&dateDescriptor=lastWeek&ts=$ts&apikey=c902c557127a2121a4b90fe59bc8d4a0&hash=$hash"
        Log.e("datedate", url)
        val request = Request.Builder()
                .url(url)
                .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {}
            override fun onResponse(call: Call, response: Response) {
                val responseData = response.body()?.string()
                comicsList = ComicUtils.prepareArray(responseData)
                adapter = ComicsAdapter(context, comicsList as ArrayList<Comic>)
                runOnUiThread {
                    comics_list_view.adapter = adapter
                }

            }
        })

        comics_list_view.setOnItemClickListener { _, _, position, _ ->
            val comic = comicsList[position]
            val detailIntent = DetailActivity.newIntent(context, comic)
            startActivity(detailIntent)
        }
    }
}

