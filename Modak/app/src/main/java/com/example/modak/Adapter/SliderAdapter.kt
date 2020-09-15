package com.example.modak.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.viewpager.widget.PagerAdapter
import com.example.modak.Model.SliderModel
import com.example.modak.R

class SliderAdapter(val sliderModel: ArrayList<SliderModel>) : PagerAdapter() {
    override fun isViewFromObject(view: View, `object`: Any): Boolean {
        return view == `object`
    }

    override fun getCount(): Int {
        return sliderModel.size
    }

    override fun instantiateItem(container: ViewGroup, position: Int): Any {
        val view = LayoutInflater.from(container.context).inflate(R.layout.food__image_viewpager,container,false)

        val image : ImageView=view.findViewById(R.id.viewpager_image)
        image.setImageResource(sliderModel.get(position).image)
        container.addView(view,0)
        return view
    }

    override fun destroyItem(container: ViewGroup, position: Int, `object`: Any) {
        container.removeView(`object` as View)
    }
}