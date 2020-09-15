package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Model.Notofication_Model
import com.example.modak.R

class Notification_Adapter(val notificationModel : ArrayList<Notofication_Model>) :
    RecyclerView.Adapter<Notification_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(itemModel : Notofication_Model)
        {
            val image : ImageView =itemView.findViewById(R.id.notification_images)
            val desc : TextView =itemView.findViewById(R.id.notification_description)
            val date : TextView=itemView.findViewById(R.id.notification_date)

            image.setImageResource(itemModel.image)
            desc.setText(itemModel.desc)
            date.setText(itemModel.date)

            Glide.with(itemView.context) .load(itemModel.image).apply(RequestOptions().circleCrop()) .into(image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.notification_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return notificationModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(notificationModel[position])
    }
}