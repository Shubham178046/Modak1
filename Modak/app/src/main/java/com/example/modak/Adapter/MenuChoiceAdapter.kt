package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Model.MenuChoiceModel
import com.example.modak.R
import com.example.modak.Sample
import kotlinx.android.synthetic.main.activity_sample.*

class MenuChoiceAdapter(val menuChoiceModel: ArrayList<MenuChoiceModel>, var onClick: OnClick) :
    RecyclerView.Adapter<MenuChoiceAdapter.ViewHolder>() {
    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        fun bind(itemModel : MenuChoiceModel)
        {
            val image : ImageView=itemView.findViewById(R.id.menu_image)
            val name : TextView=itemView.findViewById(R.id.menu_name)

            image.setImageResource(itemModel.image)
            name.setText(itemModel.name)

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.menu_choice,parent,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
       return menuChoiceModel.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
       holder.bind(menuChoiceModel[position])
        var sample: Sample=Sample()
        holder.itemView.setOnClickListener {

            onClick.onClick()

        }
    }
    interface OnClick{ fun onClick() }
}