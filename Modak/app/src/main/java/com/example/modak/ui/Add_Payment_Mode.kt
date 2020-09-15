package com.example.modak.ui

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.example.modak.Fragment.Payment
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_add__payment__mode.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.custom_appbar.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class Add_Payment_Mode : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add__payment__mode)
        var fragmentmanager : FragmentManager =supportFragmentManager
        var flag: Int = 0
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_appbar)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_FULLSCREEN,
            WindowManager.LayoutParams.FLAG_FULLSCREEN
        )
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
        title_editprofilr.setText("Payment Method")
        close_menu.visibility = View.INVISIBLE

        back_icon.setOnClickListener(
            {
                super.onBackPressed()
            }
        )
        val card_spinner: Spinner = findViewById(R.id.spin_select_card_type)
        val mounth_spinner: Spinner = findViewById(R.id.spin_select_month_card_expiration)
        val year_spinner: Spinner = findViewById(R.id.spin_select_year_card_expiration)

        //// card spinner adapter
        val card_type = ArrayList<String>()

        card_type.add("Visa")
        card_type.add("Master")
        card_type.add("American")
        card_type.add("Discover")
        card_type.add("UnionPay")
        card_type.add("Google Pay")
        card_type.add("Paytm")
        card_type.add("Cash")
        card_type.add("Apple Pay")

        var adapter = ArrayAdapter(this,android.R.layout.simple_spinner_item, card_type)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        card_spinner.adapter = adapter

        //// mounth spinner adapter
        val mounth = ArrayList<String>()

        mounth.add("Month")
        mounth.add("01")
        mounth.add("02")
        mounth.add("03")
        mounth.add("04")
        mounth.add("05")
        mounth.add("06")
        mounth.add("07")
        mounth.add("08")
        mounth.add("09")
        mounth.add("10")
        mounth.add("11")
        mounth.add("12")

        var mounth_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mounth)
        mounth_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        mounth_spinner.adapter = mounth_adapter

        //// year spinner adapter
        val year = ArrayList<String>()
        year.add("Year")
        year.add("2021")
        year.add("2022")
        year.add("2023")
        year.add("2024")
        year.add("2025")
        year.add("2026")
        year.add("2027")
        year.add("2028")
        year.add("2029")
        year.add("2030")
        year.add("2031")
        year.add("2032")


        var year_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, year)
        year_adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)

        year_spinner.adapter = year_adapter

        card_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                val card_layout: LinearLayout = findViewById(R.id.card_layout)
                val wallet_layout: LinearLayout = findViewById(R.id.upi_id_layout)

                if (position == 5 || position == 6 || position == 7 || position == 8) {
                    flag = 1
                    card_layout.visibility = View.GONE
                    wallet_layout.visibility = View.VISIBLE

                }
                else {
                    flag = 0
                    wallet_layout.visibility = View.GONE
                    card_layout.visibility = View.VISIBLE

                }
            }

        }

        btn_save_paymnet_method_card.setOnClickListener {
          //  var fragmenttransaction : FragmentTransaction=fragmentmanager.beginTransaction()
           if (flag == 0)
           {

            if (card_spinner.selectedItemPosition == 0) {
                Toast.makeText(applicationContext, "Please Select Card Type", Toast.LENGTH_LONG).show()
            } else if (edt_name_on_card_payment_method.text.toString().trim().isEmpty()) {
                edt_name_on_card_payment_method.error = "Please Enter Name On Card"
            } else if (edt_card_no_payment_method.text.toString().trim().isEmpty()) {
                edt_card_no_payment_method.error = "Please Enter Card Number"
            } else if (edt_card_no_payment_method.text.length < 16) {
                edt_card_no_payment_method.error = "Enter Valid Card Number"
            } else if (mounth_spinner.selectedItemPosition == 0) {
                Toast.makeText(applicationContext, "Please Select Expiry Month", Toast.LENGTH_LONG)
                    .show()
            } else if (year_spinner.selectedItemPosition == 0) {
                Toast.makeText(applicationContext, "Please Select Expiry Year", Toast.LENGTH_LONG)
                    .show()
            } else if (edt_cvv_code_payment_method.text.toString().trim().isEmpty()) {
                edt_cvv_code_payment_method.error = "Please Enter CVV Number"
            } else if (edt_cvv_code_payment_method.text.length < 3) {
                edt_cvv_code_payment_method.error = "Enter Valid CVV Number"
            } else if (edt_billing_zipcode_payment_method.text.toString().trim().isEmpty()) {
                edt_billing_zipcode_payment_method.error = "Enter ZipCode"
            } else if (payment_checkbox.isChecked.equals(false)) {
                Toast.makeText(applicationContext, "Please Select Conditions", Toast.LENGTH_LONG).show()
            } else {
                val returnIntent : Intent=Intent()
                returnIntent.putExtra("card_type", card_spinner.selectedItem.toString())
                returnIntent.putExtra("card_name", edt_card_no_payment_method.text.toString())
                setResult(Activity.RESULT_OK,returnIntent)
                finish()

            }
           }
            else if(flag ==1)
           {
               if (edt_upi_id.text.toString().trim().isEmpty()) {
                   edt_upi_id.error = "Enter Your UPI Id"
               }
               else if (payment_checkbox.isChecked.equals(false)) {
                   Toast.makeText(applicationContext, "Please Select Conditions", Toast.LENGTH_LONG).show()
               }
               else {

                   val returnIntent : Intent=Intent()
                   returnIntent.putExtra("card_type", card_spinner.selectedItem.toString())
                   setResult(Activity.RESULT_OK,returnIntent)
                   finish()
               }
           }
        }
    }

    override fun onBackPressed() {
        finish()
    }
}