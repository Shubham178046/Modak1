package com.example.modak.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Review_Item_List_Adapter
import com.example.modak.Model.Review_Item_List_Model
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_review__order.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import java.util.ArrayList

class Review_Order : AppCompatActivity() {
    val reviewItemListModel=ArrayList<Review_Item_List_Model>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review__order)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Review Order")
        gps_icon.visibility= View.INVISIBLE
        toolbar_back.setOnClickListener {
           finish()
        }
       val recyclerView : RecyclerView=findViewById(R.id.ll_item_order_review_ordered_item)

        recyclerView.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
        reviewItemListModel.add(Review_Item_List_Model(R.drawable.img_review_order,"Green Capsicum pepped up with Cheese and spices","3","$75"))
        reviewItemListModel.add(Review_Item_List_Model(R.drawable.img_review_order1,"Sliced Panner With Tandoori Masala and Cheese","2","$50"))
        reviewItemListModel.add(Review_Item_List_Model(R.drawable.img_review_order,"Veg Steak With Cheese Spaghtti ","1","$25"))
        reviewItemListModel.add(Review_Item_List_Model(R.drawable.img_review_order1,"Babycorn Mushroom Chilli Or Babycorn Chilli Fried","4","$100"))
        reviewItemListModel.add(Review_Item_List_Model(R.drawable.img_review_order,"Green Capsicum pepped up with Cheese and spices","3","$75"))

        val reviewItemListAdapter= Review_Item_List_Adapter(reviewItemListModel)
        recyclerView.adapter=reviewItemListAdapter


        tv_confirm_order_review_order.setOnClickListener {
            startActivity(Intent(applicationContext,Confirmation::class.java))
        }
    }
}