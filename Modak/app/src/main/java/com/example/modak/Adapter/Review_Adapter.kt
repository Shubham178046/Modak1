package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Adapter.Review_Adapter.ViewHolder
import com.example.modak.Model.Review_model
import com.example.modak.R
import kotlinx.android.synthetic.main.review_item.view.*

class Review_Adapter(val review_model : ArrayList<Review_model>):
    RecyclerView.Adapter<ViewHolder>() {
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {

        fun bindItem(itemModel :Review_model)
        {
            val image : ImageView=itemView.findViewById(R.id.profile_images)
            val desc : TextView=itemView.findViewById(R.id.profile_description)
            val name :TextView=itemView.findViewById(R.id.profile_name)
            val date : TextView=itemView.findViewById(R.id.profile_date)


            image.setImageResource(itemModel.image)
            name.setText(itemModel.name)
            desc.setText(itemModel.desc)
            date.setText(itemModel.date)

            Glide.with(itemView.context) .load(itemModel.image).apply(RequestOptions().circleCrop()) .into(image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view=LayoutInflater.from(parent.context).inflate(R.layout.review_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return review_model.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(review_model[position])
    }
}