package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Offer_Model
import com.example.modak.R

class Offer_Adapter(val offerModel: ArrayList<Offer_Model>) :
    RecyclerView.Adapter<Offer_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(itemModel : Offer_Model)
        {
            val image : ImageView=itemView.findViewById(R.id.offer_image)
            val name : TextView=itemView.findViewById(R.id.offer_name)

            image.setImageResource(itemModel.image)
            name.setText(itemModel.offer_name)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view= LayoutInflater.from(parent.context).inflate(R.layout.offer_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return offerModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(offerModel[position])
    }
}