package com.enosnery.marvelstore.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.bumptech.glide.Glide
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.drawable.button_calc_number
import com.enosnery.marvelstore.R.layout.activity_details
import com.enosnery.marvelstore.classes.Comic
import kotlinx.android.synthetic.main.activity_details.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_PRICE = "price"
        const val EXTRA_URL = "url"
        const val EXTRA_RARE = "rare"

        fun newIntent(context: Context, comic: Comic): Intent {
            val detailIntent = Intent(context, DetailActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, comic.title)
            detailIntent.putExtra(EXTRA_PRICE, comic.price)
            detailIntent.putExtra(EXTRA_URL, comic.pictureURL)
            detailIntent.putExtra(EXTRA_RARE, comic.rare)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_details)
        text_detail_container.setBackgroundColor(Color.BLACK)
        text_main.text = getString(R.string.app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10, 10, 10, 10)
        purchase_button.setBackgroundResource(button_calc_number)


        val title = intent.extras.getString(EXTRA_TITLE)
        val price = intent.extras.getDouble(EXTRA_PRICE)
        val url = intent.extras.getString(EXTRA_URL)
        val rare = intent.extras.getBoolean(EXTRA_RARE)

        Log.e("details", title)
        Log.e("details", price.toString())
        Log.e("details", url)
        Log.e("details", rare.toString())
        detail_title.text = title
        detail_price.text = price.toString()
        if(rare) {
            detail_rare.text = "Rare Comic!"
        }else{
            detail_rare.text = "Common Comic"
        }

        Glide.with(this).load(url).into(detail_image)
    }
}