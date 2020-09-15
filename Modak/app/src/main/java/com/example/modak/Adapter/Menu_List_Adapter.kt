package com.example.modak.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Menu_List_Model
import com.example.modak.R
import com.example.modak.ui.Order_Selection
import java.util.ArrayList

class Menu_List_Adapter(val menuListModel: ArrayList<Menu_List_Model>) :
    RecyclerView.Adapter<Menu_List_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView)  {
        var count : Int =0
        fun bindItem(menuListModel: Menu_List_Model)
        {
            val dish_image : ImageView=itemView.findViewById(R.id.itemimage)
            val name : TextView=itemView.findViewById(R.id.itmnametxtview)
            val price : TextView=itemView.findViewById(R.id.itmpricetxtviewe)
            val quantity : TextView=itemView.findViewById(R.id.tv_qty_item)
            val addbtn : ImageView =itemView.findViewById(R.id.icon_nextimgview)
            val minus_btn : ImageView=itemView.findViewById(R.id.icon_preimgview)
            dish_image.setImageResource(menuListModel.image)
            name.setText(menuListModel.name)
            price.setText(menuListModel.price)
            quantity.setText(menuListModel.quantity
            )

            addbtn.setOnClickListener {
                count=quantity.text.toString().toInt()
                count++
                quantity.setText(count.toString())
            }

            minus_btn.setOnClickListener {
                count=quantity.text.toString().toInt()
                count--
                quantity.setText(count.toString())
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_list_row,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return menuListModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(menuListModel[position])

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context,Order_Selection::class.java))
        }
    }
}