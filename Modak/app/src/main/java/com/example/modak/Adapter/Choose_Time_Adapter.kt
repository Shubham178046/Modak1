package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Choose_Time_Model
import com.example.modak.R
import com.example.modak.ui.Order_Selection
import kotlin.properties.Delegates

var preselectorpositions by Delegates.notNull<Int>()
class Choose_Time_Adapter(var chooseTimeModel: ArrayList<Choose_Time_Model> , var onClick : OnClick) :
    RecyclerView.Adapter<Choose_Time_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val image : ImageView=itemView.findViewById(R.id.time_image)
        val time_txt : TextView=itemView.findViewById(R.id.time_txt)
        fun bindItem(itemModel : Choose_Time_Model)
        {

            time_txt.setText(itemModel.time)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.choose_time_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return chooseTimeModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bindItem(chooseTimeModel[position])
        val orderSelection=Order_Selection()
        var selected : Boolean = chooseTimeModel.get(position).selected

        if(selected)
        {
            holder.image.setImageResource(R.mipmap.chacked_breakfast_list)
            preselectorpositions=position
        }
        else
        {
            holder.image.setImageResource(R.mipmap.unchacked_breakfast_list)
        }

        holder.itemView.setOnClickListener {

            if(preselectorpositions !=position)
            {
                chooseTimeModel.get(position).selected = true
                chooseTimeModel.get(preselectorpositions).selected = false
                onClick.onClick(position, preselectorpositions)
                preselectorpositions=position
            }

        }
    }
    interface OnClick{ fun onClick(position: Int, preselectorpositions : Int) }
}