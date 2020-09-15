package com.example.modak.Adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.Payment_Model
import com.example.modak.R
import com.example.modak.ui.Review_Order

class Payment_Adapter(val paymentModel: ArrayList<Payment_Model>) :
    RecyclerView.Adapter<Payment_Adapter.ViewHolder>() {
    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bindItem(paymentModel: Payment_Model) {
            val cardImage: ImageView = itemView.findViewById(R.id.card_img)
            val cardNumberOrName: TextView = itemView.findViewById(R.id.card_name_number)
            val cardAmount: TextView = itemView.findViewById(R.id.card_amount)

            cardImage.setImageResource(paymentModel.card_image)
            cardNumberOrName.setText(paymentModel.card_name_number)
            cardAmount.setText(paymentModel.amount)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
       val view = LayoutInflater.from(parent.context).inflate(R.layout.payment_item,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return paymentModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindItem(paymentModel[position])

        holder.itemView.setOnClickListener {
            holder.itemView.context.startActivity(Intent(holder.itemView.context,Review_Order::class.java))
        }
    }
}