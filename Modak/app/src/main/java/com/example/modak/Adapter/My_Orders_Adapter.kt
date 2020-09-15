package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.My_Orders_Model
import com.example.modak.R

class My_Orders_Adapter(val myOrdersModel: ArrayList<My_Orders_Model>) :
    RecyclerView.Adapter<My_Orders_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(itemModel : My_Orders_Model)
        {
            val item_image : ImageView=itemView.findViewById(R.id.order_item_image)
            val item_name : TextView=itemView.findViewById(R.id.order_item_name)
            val item_price : TextView=itemView.findViewById(R.id.order_item_price)
            val item_quan : TextView=itemView.findViewById(R.id.order_item_quantity)
            val final_price : TextView=itemView.findViewById(R.id.order_final_price)

            item_image.setImageResource(itemModel.image)
            item_name.setText(itemModel.name)
            item_price.setText(itemModel.item_price)
            item_quan.setText(itemModel.quantity)
            final_price.setText(itemModel.final_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.my_orders_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
         return myOrdersModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(myOrdersModel[position])
    }
}