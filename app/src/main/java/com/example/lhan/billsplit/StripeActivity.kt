package com.example.lhan.billsplit

import android.app.Dialog
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.view.WindowManager
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.stripe.android.Stripe
import com.stripe.android.TokenCallback
import com.stripe.android.model.Card
import com.stripe.android.model.Token
import kotlinx.android.synthetic.main.activity_main.*

class StripeActivity : AppCompatActivity() {

    lateinit var stripe: Stripe
    val publishKey: String = "pk_test_O5mAjnZGw0WhPEmt7cRODuTZ"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        stripe = Stripe(this, publishKey)

        OpenDialog()
    }

    private fun OpenDialog() {

        val dialog = Dialog(this)
        dialog.setContentView(R.layout.activity_stripe)
        val lp : WindowManager.LayoutParams = WindowManager.LayoutParams().apply {
            copyFrom(dialog.window?.attributes)
            width = WindowManager.LayoutParams.MATCH_PARENT
            height = WindowManager.LayoutParams.WRAP_CONTENT
        }

        val submit = dialog.findViewById<View>(R.id.submit) as TextView
        val cardNo = dialog.findViewById<View>(R.id.cardNo) as EditText
        val month = dialog.findViewById<View>(R.id.month) as EditText
        val year = dialog.findViewById<View>(R.id.year) as EditText
        val cvv = dialog.findViewById<View>(R.id.cvv) as EditText

        submit.setOnClickListener {
            when {
                cardNo.length() == 0 || month.length() == 0 || year.length() == 0 || cvv.length() == 0 ->
                    Toast.makeText(this@StripeActivity, "Please fill all the fields"
                        , Toast.LENGTH_SHORT).show()
                cardNo.length() < 16 -> Toast.makeText(this@StripeActivity, "Please enter" +
                        " valid Card No.", Toast.LENGTH_SHORT).show()
                else -> {
                    validateCard(cardNo.text.toString(), month.text.toString(), year.text.toString(), cvv.text.toString())
                    dialog.dismiss()
                }
            }
        }
        dialog.show()
        dialog.getWindow()?.setAttributes(lp)
    }

    private fun validateCard(card: String?, month: String, year: String, cvv: String?) {
        val cards = Card(card, Integer.valueOf(month), Integer.valueOf(year), cvv)
        cards.currency = "USD"
        stripe.createToken(cards, object : TokenCallback {
            override fun onSuccess(token: Token?) {
                Log.v("Token!","Token Created!!"+ token!!.getId())
                Toast.makeText(this@StripeActivity, "Token Created!!", Toast.LENGTH_SHORT).show()
                chargeCard(token.id)
            }

            override fun onError(error: Exception?) {
                Toast.makeText(this@StripeActivity, error!!.message, Toast.LENGTH_SHORT).show()
                error.printStackTrace()
            }

        })

    }

    private fun chargeCard(token: String?) {
        // Pass that token, amount to your server using API to process payment.

    }
}