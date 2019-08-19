package com.enosnery.marvelstore.activity

import com.enosnery.marvelstore.adapters.ComicsAdapter
import android.content.Context
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.enosnery.marvelstore.classes.Comic
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.string.*
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.*
import org.apache.commons.codec.digest.DigestUtils
import com.enosnery.marvelstore.utils.ComicUtils
import kotlinx.android.synthetic.main.list_view_item.*
import org.apache.commons.codec.binary.Hex
import java.io.IOException


class MainActivity : AppCompatActivity() {

    private val client = OkHttpClient()
    val context = this
    lateinit var adapter: ComicsAdapter
    lateinit var comicsList : MutableList<Comic>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
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
            // 1
            Log.e("details", comicsList[position].title)
            Log.e("details", comicsList[position].price.toString())
            Log.e("details", comicsList[position].pictureURL)
            Log.e("details", comicsList[position].rare.toString())
            val comic = comicsList[position]

            // 2
            val detailIntent = DetailActivity.newIntent(context, comic)

            // 3
            startActivity(detailIntent)
        }
    }
}

