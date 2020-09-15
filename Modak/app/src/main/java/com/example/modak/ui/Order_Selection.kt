package com.example.modak.ui

import android.content.Intent
import android.location.Address
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Address_Adapter
import com.example.modak.Adapter.Address_Time_Adapter
import com.example.modak.Adapter.Choose_Time_Adapter
import com.example.modak.Fragment.adapter
import com.example.modak.Model.Address_Model
import com.example.modak.Model.Choose_Time_Model
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_order__selection.*
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.custom_toolbar.*

 class Order_Selection : AppCompatActivity() {
    var address_time_adapter : Address_Time_Adapter?=null
    val chooseTimeModel= ArrayList<Choose_Time_Model>()
     var chooseTimeAdapter: Choose_Time_Adapter?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order__selection)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Ahmedabad")
        //chooseTimeAdapter=

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        toolbar_back.setOnClickListener {
            super.onBackPressed()
        }
        order_dine_in.setOnClickListener {
            order_dine_in_select.setImageResource(R.mipmap.icon_dinein_selected)
            order_dinein_txt.setTextColor(resources.getColor(R.color.red_color))
            order_dine_in_check.setImageResource(R.mipmap.chacked_breakfast_list)

            order_takeout_select.setImageResource(R.mipmap.icon_takeout_unselected)
            order_takeout_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_takeout_check.setImageResource(R.mipmap.unchacked_breakfast_list)

            order_delivery_select.setImageResource(R.mipmap.icon_delivery_unselected)
            order_delivery_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_delivery_check.setImageResource(R.mipmap.unchacked_breakfast_list)
        }

        order_takeout.setOnClickListener {

            order_dine_in_select.setImageResource(R.mipmap.icon_dinein_unselected)
            order_dinein_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_dine_in_check.setImageResource(R.mipmap.unchacked_breakfast_list)

            order_takeout_select.setImageResource(R.mipmap.icon_takeout_selected)
            order_takeout_txt.setTextColor(resources.getColor(R.color.red_color))
            order_takeout_check.setImageResource(R.mipmap.chacked_breakfast_list)

            order_delivery_select.setImageResource(R.mipmap.icon_delivery_unselected)
            order_delivery_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_delivery_check.setImageResource(R.mipmap.unchacked_breakfast_list)

            ll_select_order_title.visibility= View.VISIBLE
        }

        order_ll_delivery.setOnClickListener {
            order_dine_in_select.setImageResource(R.mipmap.icon_dinein_unselected)
            order_dinein_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_dine_in_check.setImageResource(R.mipmap.unchacked_breakfast_list)

            order_takeout_select.setImageResource(R.mipmap.icon_takeout_unselected)
            order_takeout_txt.setTextColor(resources.getColor(R.color.grey_color))
            order_takeout_check.setImageResource(R.mipmap.unchacked_breakfast_list)

            order_delivery_select.setImageResource(R.mipmap.icon_delivery_selected)
            order_delivery_txt.setTextColor(resources.getColor(R.color.red_color))
            order_delivery_check.setImageResource(R.mipmap.chacked_breakfast_list)

            ll_select_order_title.visibility= View.GONE
        }

        val recyclerView : RecyclerView=findViewById(R.id.lv_select_time_list)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)


        chooseTimeModel.add(Choose_Time_Model("As soon as possible(ASAP) (US$ 200 Extra)",false))
        chooseTimeModel.add(Choose_Time_Model("30 mins (US$ 150Extra)",true))
        chooseTimeModel.add(Choose_Time_Model("1 hour by 5 PM (US$ 100 Extra)",false))
        chooseTimeModel.add(Choose_Time_Model("1:30 hr",false))

        chooseTimeAdapter=Choose_Time_Adapter(chooseTimeModel, object : Choose_Time_Adapter.OnClick
        {
            override fun onClick(position: Int, preselectorpositions: Int) {
                chooseTimeAdapter!!.notifyItemChanged(preselectorpositions)
                chooseTimeAdapter!!.notifyItemChanged(position)
            }

        })
        recyclerView.adapter=chooseTimeAdapter
        chooseTimeAdapter!!.notifyDataSetChanged()



        ////////address adapter

        val address_recyclerView : RecyclerView=findViewById(R.id.lv_select_address_list)
        val list= ArrayList<Address_Model>()

        list.add(Address_Model("Home","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",true))
        list.add(Address_Model("Office","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 1","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 2","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 3","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 4","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))

        address_recyclerView.layoutManager= LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        address_time_adapter= Address_Time_Adapter(list,object : Address_Time_Adapter.OnClick{
            override fun onClick(position: Int, preselectorposition1: Int) {
                address_time_adapter!!.notifyItemChanged(preselectorposition1)
                address_time_adapter!!.notifyItemChanged(position)
            }

        })
        address_recyclerView.adapter=address_time_adapter
        address_time_adapter!!.notifyDataSetChanged()

        btn_proceed.setOnClickListener {
            startActivity(Intent(applicationContext,Basket::class.java))
        }

    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return true
    }
}