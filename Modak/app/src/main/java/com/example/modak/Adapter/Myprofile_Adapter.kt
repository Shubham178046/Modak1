package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.MyProfile_Model
import com.example.modak.R

class Myprofile_Adapter(val myprofileModel: ArrayList<MyProfile_Model>) : RecyclerView.Adapter<Myprofile_Adapter.ViewHolder>() {

    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)
    {
        fun bindItem(itemModel : MyProfile_Model)
        {
            val images : ImageView=itemView.findViewById(R.id.food_image)
            images.setImageResource(itemModel.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view : View= LayoutInflater.from(parent.context).inflate(R.layout.my_profile_recyclerview_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return myprofileModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(myprofileModel[position])
    }
}