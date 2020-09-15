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
import com.example.modak.Adapter.My_Orders_Adapter
import com.example.modak.Model.My_Orders_Model
import com.example.modak.R
import kotlinx.android.synthetic.main.custom_toolbar.*
import java.util.ArrayList

class Confirmation : AppCompatActivity() {
    val My_Orders_Model = ArrayList<My_Orders_Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_confirmation)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Confirmation")
        gps_icon.visibility= View.INVISIBLE

        val recyclerView : RecyclerView=findViewById(R.id.lv_items_selected_confirm_order)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)

        My_Orders_Model.add(My_Orders_Model(R.mipmap.img_review_order,"Green Capsicum pepped up with Cheese and spices","3","$25","$75"))
        My_Orders_Model.add(My_Orders_Model(R.mipmap.img_review_order,"Sliced panner with tandoori Masala","2","$20","$40"))
        My_Orders_Model.add(My_Orders_Model(R.mipmap.img_review_order,"Green Capsicum pepped up with Cheese and spices","3","$25","$75"))
        My_Orders_Model.add(My_Orders_Model(R.mipmap.img_review_order,"Cheese and spices with gril panner","4","$10","$40"))
        My_Orders_Model.add(My_Orders_Model(R.mipmap.img_review_order,"Sliced Panner With Tandoori Masala","3","$30","$60"))

        val My_Orders_Adapter=My_Orders_Adapter(My_Orders_Model)
        recyclerView.adapter=My_Orders_Adapter
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val items = item.itemId

        when(items)
        {
            R.id.home -> {startActivity(Intent(applicationContext,Home_Navigation::class.java))
            finish() }
        }
        return super.onOptionsItemSelected(item)
    }
}