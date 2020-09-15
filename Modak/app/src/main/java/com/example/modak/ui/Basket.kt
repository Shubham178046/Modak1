package com.example.modak.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Patterns
import android.view.View
import android.view.WindowManager
import android.widget.ArrayAdapter
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.core.view.get
import androidx.fragment.app.Fragment
import com.example.modak.Fragment.Payment
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_basket.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class Basket : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_basket)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Basket")
        gps_icon.visibility= View.INVISIBLE

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)



        toolbar_back.setOnClickListener {
            super.onBackPressed()
        }

        val country_spinner: Spinner = findViewById(R.id.edt_country_basket)
        val city_spinner: Spinner = findViewById(R.id.edt_city_basket)
        val state_spinner : Spinner=findViewById(R.id.edt_state_basket)


        val country = ArrayList<String>()

        country.add("Country")
        country.add("India")
        country.add("Australia")
        country.add("United Arab Emirates")
        country.add("America")
        country.add("Russia")
        country.add("Germany")

        var india_city = arrayOf("City","Goa", "Vadodara", "Surat", "Delhi", "Mumbai", "Jaunpur", "Rajkot")

        var state = arrayOf("State", "Gujarat","Delhi","Maharastra","UP", "Bihar")

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, country)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_spinner.adapter = adapter


        var city_blank = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, india_city)
        city_blank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        city_spinner.adapter = city_blank

        var state_adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, state)
        state_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        state_spinner.adapter = state_adapter
        val homeNavigation = Home_Navigation()
        tv_select_payment_basket.setOnClickListener {
            if(edt_firstname_basket.text.toString().isEmpty())
            {
                edt_firstname_basket.error="Field Cannot Be Blank"
            }
            else if(edt_lastname_basket.text.toString().isEmpty())
            {
                edt_lastname_basket.error="Field Cannot Be Blank"
            }
            else if(edt_email_basket.text.toString().isEmpty())
            {
                edt_email_basket.error="Field Cannot Be Blank"
            }
            else if(!Patterns.EMAIL_ADDRESS.matcher(edt_email_basket.text.toString().trim()).matches())
            {
                edt_email_basket.error="Invalid Email Id"
            }
            else if(edt_mobile_basket.text.toString().isEmpty())
            {
                edt_mobile_basket.error="Field Cannot Be Blank"
            }
            else if(edt_homeadd_basket.text.toString().isEmpty())
            {
                edt_homeadd_basket.error="Field Cannot Be Blank"
            }
            else if(edt_address1_basket.text.toString().isEmpty())
            {
                edt_address1_basket.error="Field Cannot Be Blank"
            }
            else if(edt_address2_basket.text.toString().isEmpty())
            {
                edt_address2_basket.error="Field Cannot Be Blank"
            }
            else if(city_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(applicationContext,"Please Select City", Toast.LENGTH_LONG).show()
            }
            else if(state_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(applicationContext,"Please Select State", Toast.LENGTH_LONG).show()
            }
            else if(country_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(applicationContext,"Please Select Country", Toast.LENGTH_LONG).show()
            }
            else if(edt_zipcode_basket.text.toString().isEmpty())
            {
                edt_zipcode_basket.error="Enter ZipCode"
            }
            else if(iv_terms_condition_basket.isChecked.equals(false))
            {
                Toast.makeText(applicationContext,"Select Terms And Condition", Toast.LENGTH_LONG).show()
            }
            else{
                val intent= Intent(applicationContext,Home_Navigation::class.java)
                intent.putExtra("key","access")
                startActivity(intent)
            }
        }
    }

}