package com.example.modak.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Payment_Adapter
import com.example.modak.Model.Payment_Model
import com.example.modak.R
import kotlinx.android.synthetic.main.custom_appbar.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class Payment_Method : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_payment__method)
        /*supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        supportActionBar?.title=null
        toolbar_title.setText("Payment Method")*/

       /* toolbar_back.setOnClickListener(
            {
                startActivity(Intent(applicationContext,Home_Navigation::class.java))
                finish()
            }
        )*/

       /* val recycler_view : RecyclerView=findViewById(R.id.payment_recyclerview)
        recycler_view.layoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        val paymentModel =ArrayList<Payment_Model>()
        paymentModel.add(Payment_Model(R.drawable.visa_card,"**** **** **** **1245",""))
        paymentModel.add(Payment_Model(R.drawable.visa_debit,"**** **** **** **1245",""))
        paymentModel.add(Payment_Model(R.drawable.google_wallet,"Google Wallet",""))
        paymentModel.add(Payment_Model(R.drawable.paytm,"Paytm Wallet","\u20B9"+ "0.00"))
        paymentModel.add(Payment_Model(R.drawable.apple_wallet,"Apple Pay",""))
        paymentModel.add(Payment_Model(R.drawable.cash,"Cash",""))

        val intent : Intent?=intent
        val card_type : String?=intent?.getStringExtra("card_type").toString()
        val card_name_number:String?= intent?.getStringExtra("card_name").toString()
        if(card_type.equals("Visa"))
        {
            paymentModel.add(Payment_Model(R.drawable.visa_card,card_name_number.toString(),""))
        }
        else if(card_type.equals("Master"))
        {
            paymentModel.add(Payment_Model(R.drawable.bt_ic_mastercard,card_name_number.toString(),""))
        }
        else if(card_type.equals("American"))
        {
            paymentModel.add(Payment_Model(R.drawable.bt_ic_amex,card_name_number.toString(),""))
        }
        else if(card_type.equals("Cash"))
        {
            paymentModel.add(Payment_Model(R.drawable.cash,"Cash",""))
        }
        else if(card_type.equals("Discover"))
        {
            paymentModel.add(Payment_Model(R.drawable.bt_ic_discover,card_name_number.toString(),""))
        }
        else if(card_type.equals("UnionPay"))
        {
            paymentModel.add(Payment_Model(R.drawable.bt_ic_discover,card_name_number.toString(),""))
        }
        else if(card_type.equals("Google Pay"))
        {
            paymentModel.add(Payment_Model(R.drawable.google_wallet,"Google Wallet",""))
        }
        else if(card_type.equals("Paytm"))
        {
            paymentModel.add(Payment_Model(R.drawable.paytm,"Paytm Wallet","\u20B9"+ "0.00"))
        }
        else if(card_type.equals("Apple Pay"))
        {
            paymentModel.add(Payment_Model(R.drawable.apple_wallet,"Apple Wallet",""))
        }
        val paymentAdapter=Payment_Adapter(paymentModel)
        recycler_view.adapter=paymentAdapter
        paymentAdapter.notifyDataSetChanged()*/
    }

   /* override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.payment_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var items : Int = item.itemId
        when(items)
        {
            R.id.add_card -> startActivity(Intent(applicationContext,Add_Payment_Mode::class.java))
        }
        return super.onOptionsItemSelected(item)
    }*/

   /* override fun onBackPressed() {
        startActivity(Intent(applicationContext,Home_Navigation::class.java))
        finish()
    }*/
}