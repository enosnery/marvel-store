package com.enosnery.marvelstore.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.layout.activity_checkout
import com.enosnery.marvelstore.classes.Comic
import kotlinx.android.synthetic.main.activity_details.*


class CheckoutActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_TITLE = "title"
        const val EXTRA_PRICE = "price"
        const val EXTRA_URL = "url"
        const val EXTRA_RARE = "rare"

        fun newIntent(context: Context, comic: Comic): Intent {
            val detailIntent = Intent(context, CheckoutActivity::class.java)

            detailIntent.putExtra(EXTRA_TITLE, comic.title)
            detailIntent.putExtra(EXTRA_PRICE, comic.price)
            detailIntent.putExtra(EXTRA_URL, comic.pictureURL)
            detailIntent.putExtra(EXTRA_RARE, comic.rare)

            return detailIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_checkout)
        text_detail_container.setBackgroundColor(Color.BLACK)
        text_main.text = getString(R.string.app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10, 10, 10, 10)
    }
}