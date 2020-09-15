package com.example.modak.Adapter

import android.graphics.Color
import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.MyOrders_Model
import com.example.modak.R
import com.example.modak.R.mipmap.btn_reorder
import kotlinx.android.synthetic.main.myorders_item.view.*

class MyOrder_Adapter(val myordersModel: ArrayList<MyOrders_Model>) :
    RecyclerView.Adapter<MyOrder_Adapter.ViewHolder>() {
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        fun bindItem(itemModel: MyOrders_Model)
        {
            val orderid : TextView=itemView.findViewById(R.id.order_id)
            val price : TextView=itemView.findViewById(R.id.price)
            val date : TextView=itemView.findViewById(R.id.date)

            val staus_btn : Button =itemView.findViewById(R.id.status_btn)
            val order_ststus_txt : TextView=itemView.findViewById(R.id.order_status)

            orderid.setText(itemModel.id)
            price.setText(itemModel.price)
            date.setText(itemModel.date)
            val order_code : Int= itemModel.status_code

            if(order_code == 1)
            {
                staus_btn.setBackgroundResource(R.mipmap.btn_reorder)
                staus_btn.setText("Reorder")
                staus_btn.setPadding(0,0,6,0)
                order_ststus_txt.setTextColor(itemView.resources.getColor(R.color.green_color))
                order_ststus_txt.setText("Delivered")
            }
            if(order_code == 0)
            {
                staus_btn.setBackgroundResource(R.mipmap.btn_cancel)
                staus_btn.setText("Cancel")
                staus_btn.setPadding(0,0,15,0)
                order_ststus_txt.setTextColor(itemView.resources.getColor(R.color.red_color))
                order_ststus_txt.setText("Pending")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view : View=LayoutInflater.from(parent.context).inflate(R.layout.myorders_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myordersModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(myordersModel[position])
    }
}