package com.enosnery.marvelstore.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.drawable.button_calc_number
import com.enosnery.marvelstore.R.layout.activity_details
import com.enosnery.marvelstore.classes.Comic
import com.enosnery.marvelstore.classes.Purchase
import kotlinx.android.synthetic.main.activity_details.*

class DetailActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_COMIC = "comic"


        fun newIntent(context: Context, comic: Comic): Intent {
            val detailIntent = Intent(context, DetailActivity::class.java)
            detailIntent.putExtra(EXTRA_COMIC, comic)
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

        val comic = intent.extras.getSerializable(EXTRA_COMIC) as Comic

        detail_title.text = comic.title
        detail_price.text = comic.price.toString()

        Glide.with(this).load(comic.pictureURL).into(detail_image)

        purchase_button.setOnClickListener {
            val purchase = Purchase(comic.title, comic.price, purchase_amount.text.toString().toInt(), comic.rare, comic.pictureURL)
            purchase_amount.text = null
            val intent = CheckoutActivity.newIntent(this, purchase)
            startActivity(intent)
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        purchase_amount.text = null
    }
}