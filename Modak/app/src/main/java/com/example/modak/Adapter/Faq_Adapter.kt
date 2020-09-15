package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Faq_Model
import com.example.modak.R

class Faq_Adapter() : RecyclerView.Adapter<Faq_Adapter.ViewHolder>() {
    class ViewHolder(itemview : View) : RecyclerView.ViewHolder(itemview) {
        fun bindItem()
        {
            val open_btn : Button =itemView.findViewById(R.id.open_btn)
            val close_btn: Button=itemView.findViewById(R.id.close_btn)
            val layout : LinearLayout=itemView.findViewById(R.id.data_layout)


            open_btn.setOnClickListener {
                close_btn.visibility=View.VISIBLE
                open_btn.visibility=View.INVISIBLE
                layout.visibility=View.VISIBLE
            }
            close_btn.setOnClickListener {
                close_btn.visibility=View.GONE
                open_btn.visibility=View.VISIBLE
                layout.visibility=View.GONE
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.listview_faq,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return 10
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem()
    }
}