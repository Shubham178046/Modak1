package com.example.modak.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import android.widget.AdapterView.OnItemSelectedListener
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_select__city.*
import kotlinx.android.synthetic.main.custom_appbar.*

class Select_City : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select__city)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_appbar)

        title_editprofilr.setText("Select City")
        close_menu.visibility = View.INVISIBLE

        val zipcode :EditText=findViewById(R.id.zipcode_edt)
        back_icon.setOnClickListener(
            {
                startActivity(Intent(applicationContext, Home_Navigation::class.java))
            }
        )


        val country_spinner: Spinner = findViewById(R.id.country_spinner)
        val city_spinner: Spinner = findViewById(R.id.city_spinner)

        val country = ArrayList<String>()

        country.add("Country")
        country.add("India")
        country.add("Australia")
        country.add("United Arab Emirates")
        country.add("America")
        country.add("Russia")
        country.add("Germany")

        var blank_city= arrayOf("City")
        var india_city = arrayOf("City","Goa", "Vadodara", "Surat", "Delhi", "Mumbai", "Jaunpur", "Rajkot")

        var australia = arrayOf("City",
            "Sydney",
            "Albury",
            "Armidale",
            "Bathurst",
            "Blue Mountains",
            "Broken Hill",
            "Campbelltown",
            "Cessnock",
            "Dubbo",
            "Goulburn",
            "Grafton",
            "Lithgow"
        )
        var uae = arrayOf("City",
            "Abu Dhabi",
            "Ajmān",
            "Al Ain",
            "Al Awdah",
            "Al Fahlayn",
            "Al Fulayyah",
            "Al Fara",
            "Al Ghabah",
            "Al Ghabam",
            "Al Ghashban",
            "Al Hamraniyah"
        )

        var america = arrayOf("City",
            "Alexander City",
            "  Dothan",
            "Enterprise",
            "Eufaula",
            "Florence",
            "Fort Payne",
            "Gadsden",
            "Greenville",
            "Guntersville",
            "Huntsville",
            "Jasper",
            "Marion"
        )

        var russia =arrayOf("City","Barnaul",
                "Biysk",
                "Gorno-Altaysk",
                "Kamen-na-Obi",
                "Rubtsovsk")

        var germany = arrayOf("City","Aalen",
            "Bad Mergentheim",
            "Baden-Baden",
            "Bruchsal",
            "Esslingen",
            "Freiburg im Breisgau",
            "Freudenstadt",
            "Friedrichshafen")

        var adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, country)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        country_spinner.adapter = adapter

        country_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onNothingSelected(parent: AdapterView<*>?) {

            }

            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
               // val itemposition: Int = country[position]
             //   Toast.makeText(applicationContext,itemposition,Toast.LENGTH_LONG).show()
                if(position == 0)
                {
                    var city_blank = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, blank_city)
                    city_blank.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_blank
                }
                if(position == 1)
                {
                    var city_adapter = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, india_city)
                    city_adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter
                }
                if(position == 2)
                {
                    var city_adapter1 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, australia)
                    city_adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter1

                }
                if(position ==3)
                {
                    var city_adapter2 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, uae)
                    city_adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter2

                }
                if(position == 4)
                {
                    var city_adapter3 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, america)
                    city_adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter3

                }
                if(position == 5)
                {
                    var city_adapter4 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, russia)
                    city_adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter4

                }
                if(position == 6)
                {
                    var city_adapter5 = ArrayAdapter(applicationContext, android.R.layout.simple_spinner_item, germany)
                    city_adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                    city_spinner.adapter = city_adapter5

                }

            }

        }


        get_stated_btn.setOnClickListener {

            if(country_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(applicationContext,"Please Select Country",Toast.LENGTH_LONG).show()
            }
            else if(city_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(applicationContext,"Please Select City",Toast.LENGTH_LONG).show()
            }
            else if(zipcode.text.toString().trim().isEmpty())
            {
                zipcode.error="Enter ZipCode"
            }
            else
            {
                startActivity(Intent(applicationContext, Home_Navigation::class.java))
            }
        }
    }
}