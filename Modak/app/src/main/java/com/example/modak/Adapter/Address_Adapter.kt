package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Fragment.Address_List
import com.example.modak.Model.Address_Model
import com.example.modak.R
import kotlin.properties.Delegates

var preselectorposition by Delegates.notNull<Int>()

class Address_Adapter(val addressModel : ArrayList<Address_Model>) :
    RecyclerView.Adapter<Address_Adapter.ViewHolder>() {

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val title : TextView=itemView.findViewById(R.id.home_txt)
        val address : TextView=itemView.findViewById(R.id.address_txt)
        val image_status : ImageView=itemView.findViewById(R.id.address_checked_img)
        fun bindItem(itemModel : Address_Model)
        {
            title.setText(itemModel.title)
            address.setText(itemModel.address)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view=LayoutInflater.from(parent.context).inflate(R.layout.address_list_layout,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return addressModel.size
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(addressModel[position])
        val addressList = Address_List()
        var selected : Boolean = addressModel.get(position).selected

        if(selected)
        {
            //holder.image_status.visibility=View.VISIBLE
            holder.image_status.setImageResource(R.drawable.checked)
            preselectorposition=position
        }
        else
        {
            //holder.image_status.visibility=View.GONE
            holder.image_status.setImageResource(R.drawable.unchecked)
        }
        holder.itemView.setOnClickListener {

                if(preselectorposition !=position)
                {
                    addressModel.get(position).selected = true
                    addressModel.get(preselectorposition).selected = false
                    preselectorposition?.let { it1 -> addressList.refreshItem(position, it1) }
                    preselectorposition=position
                }
        }
      }
    }