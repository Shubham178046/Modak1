package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Review_Item_List_Model
import com.example.modak.R

class Review_Item_List_Adapter(val reviewItemListModel: ArrayList<Review_Item_List_Model>) :
    RecyclerView.Adapter<Review_Item_List_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bindItem(itemModel: Review_Item_List_Model)
        {
                val image : ImageView=itemView.findViewById(R.id.item_image)
                val name : TextView=itemView.findViewById(R.id.item_name)
                val quantity : TextView=itemView.findViewById(R.id.item_quantity)
                val price : TextView=itemView.findViewById(R.id.final_price)

                image.setImageResource(itemModel.image)
                name.setText(itemModel.name)
                quantity.setText(itemModel.quantity)
                price.setText(itemModel.total_price)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_item_list,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return reviewItemListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(reviewItemListModel[position])
    }
}