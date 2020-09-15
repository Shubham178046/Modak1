package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Address_Model
import com.example.modak.R
import com.example.modak.ui.Order_Selection
import kotlin.properties.Delegates

var preselectorposition1 by Delegates.notNull<Int>()
class Address_Time_Adapter(val addressModel : ArrayList<Address_Model>, var onClick: OnClick) :
    RecyclerView.Adapter<Address_Time_Adapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView =itemView.findViewById(R.id.home_txt)
        val address : TextView =itemView.findViewById(R.id.address_txt)
        val image_status : ImageView =itemView.findViewById(R.id.address_checked_img)
        fun bindItem(itemModel : Address_Model)
        {
            title.setText(itemModel.title)
            address.setText(itemModel.address)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=
            LayoutInflater.from(parent.context).inflate(R.layout.address_list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return addressModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(addressModel[position])
        val orderSelection = Order_Selection()
        var selected : Boolean = addressModel.get(position).selected

        if(selected)
        {
            holder.image_status.setImageResource(R.drawable.checked)
            preselectorposition1=position
        }
        else
        {

            holder.image_status.setImageResource(R.drawable.unchecked)
        }
        holder.itemView.setOnClickListener {

            if(preselectorposition1 !=position)
            {
                addressModel.get(position).selected = true
                addressModel.get(preselectorposition1).selected = false
                onClick.onClick(position, preselectorposition1)
                preselectorposition1=position
            }
        }
    }
    interface OnClick{ fun onClick(position: Int, preselectorposition1 : Int) }
}