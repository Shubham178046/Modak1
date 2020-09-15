package com.example.modak.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Fragment.Address_List
import com.example.modak.Model.dish_item_model
import com.example.modak.R
import com.example.modak.Sample
import com.example.modak.ui.FoodItem

class Dish_item_Adapter(val dishItemModel: ArrayList<dish_item_model>) :
    RecyclerView.Adapter<Dish_item_Adapter.ViewHolder>() {
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview)  {
        fun bindItem(itemModel : dish_item_model)
        {
            val like_image=itemView.findViewById<ImageView>(R.id.like_image)
            val profile_img: ImageView=itemView.findViewById(R.id.profile_image1)
            val chef_name: TextView=itemView.findViewById(R.id.chef_name)
            val distance : TextView=itemView.findViewById(R.id.distance)
            val price : TextView=itemView.findViewById(R.id.dish_price)
            val quantity : TextView=itemView.findViewById(R.id.quantity)
            val plusBtn :ImageView=itemView.findViewById(R.id.plus_btn)

            like_image.setImageResource(itemModel.like_img)
            profile_img.setImageResource(itemModel.profile_img)
            chef_name.setText(itemModel.chef_name)
            distance.setText(itemModel.distance)
            price.setText(itemModel.dish_price)
            quantity.setText(itemModel.quantity)

            Glide.with(itemView.context) .load(itemModel.profile_img).apply(RequestOptions().circleCrop()) .into(profile_img)

            plusBtn.setOnClickListener {
                val activity = itemView!!.context as AppCompatActivity
                val fragment = Address_List()
                activity.supportFragmentManager.beginTransaction().replace(R.id.frame_layout,fragment,fragment.javaClass.simpleName).addToBackStack(null).commit()
                //itemView.context.startActivity(Intent(itemView.context,Sample::class.java))
            }

            itemView.setOnClickListener {
                itemView.context.startActivity(Intent(itemView.context,FoodItem::class.java))
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.take_out_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return dishItemModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(dishItemModel[position])
    }
}