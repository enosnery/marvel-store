package com.enosnery.marvelstore.activity

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import com.bumptech.glide.Glide
import com.enosnery.marvelstore.R
import com.enosnery.marvelstore.R.drawable.button_calc_number
import com.enosnery.marvelstore.R.layout.activity_checkout
import com.enosnery.marvelstore.classes.Purchase
import kotlinx.android.synthetic.main.activity_checkout.*
import kotlinx.android.synthetic.main.activity_details.text_main


class CheckoutActivity : AppCompatActivity() {

    companion object {
        const val EXTRA_PURCHASE = "purchase"

        fun newIntent(context: Context, purchase: Purchase): Intent {
            val checkoutIntent = Intent(context, CheckoutActivity::class.java)

            checkoutIntent.putExtra(EXTRA_PURCHASE, purchase)

            return checkoutIntent
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(activity_checkout)
        text_checkout_container.setBackgroundColor(Color.BLACK)
        text_main.text = getString(R.string.app_name)
        text_main.setTextColor(Color.WHITE)
        text_main.setBackgroundColor(Color.RED)
        text_main.setPadding(10, 10, 10, 10)
        checkout_button.setBackgroundResource(button_calc_number)


        val purchase = intent.extras.getSerializable(EXTRA_PURCHASE) as Purchase
        checkout_title.text = purchase.title
        checkout_price.text = purchase.price.toString()
        checkout_amount.text = purchase.amount.toString()
        Glide.with(this).load(purchase.url).into(checkout_image)

        checkout_total.text = String.format("%.2f",purchase.price * purchase.amount)



        checkout_coupon.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {

            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {


            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (s != null) {
                    if (purchase.rare) {
                        if (s.toString() == "rareCoupon") {
                            val totalValue = checkout_total.text.toString().toDouble()
                            val newValue = totalValue - (0.25 * totalValue)
                            checkout_total.text = String.format("%.2f", newValue)
                        }else{
                            checkout_total.text = String.format("%.2f",purchase.price * purchase.amount)
                        }
                    }else{
                        if (s.toString() == "commonCoupon") {
                            val totalValue = checkout_total.text.toString().toDouble()
                            val newValue = totalValue - (0.1 * totalValue)
                            checkout_total.text = String.format("%.2f", newValue)
                        }else{
                            checkout_total.text = String.format("%.2f",purchase.price * purchase.amount)
                        }
                    }
                }
            }

        })

        checkout_button.setOnClickListener {
            val intent = MainActivity.newIntent(this, true)
            startActivity(intent)
        }

    }
}