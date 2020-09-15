package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Model.ItemDetailModel
import com.example.modak.R

class ItemDetailAdapter(val itemDetailModel: ArrayList<ItemDetailModel>) :
    RecyclerView.Adapter<ItemDetailAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {
        fun bindItem(itemModel : ItemDetailModel)
        {
            val profile_img : ImageView=itemView.findViewById(R.id.civ_chef_img_review)
            val name : TextView=itemView.findViewById(R.id.tv_chef_name_item_review)
            val ratings : RatingBar=itemView.findViewById(R.id.user_ratingBar1_overall1)
            val bref_desc : TextView=itemView.findViewById(R.id.tv_review_brief_item)

            profile_img.setImageResource(itemModel.image)
            name.setText(itemModel.name)
            ratings.rating=itemModel.rating
            bref_desc.setText(itemModel.desc)

            Glide.with(itemView.context) .load(itemModel.image).apply(RequestOptions().circleCrop()) .into(profile_img)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.review_item_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return itemDetailModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(itemDetailModel[position])
    }
}