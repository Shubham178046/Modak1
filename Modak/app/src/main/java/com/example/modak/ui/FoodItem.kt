package com.example.modak.ui

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.*
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Adapter.SliderAdapter
import com.example.modak.Fragment.DetailsFragment
import com.example.modak.Fragment.ReviewFragment
import com.example.modak.Model.SliderModel
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_food_item.*
import kotlinx.android.synthetic.main.activity_food_item.tv_details_title_text
import kotlinx.android.synthetic.main.activity_food_item.tv_review_title_text
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.custom_toolbar.*
import kotlinx.android.synthetic.main.filter_menu.*
import java.util.*

class FoodItem : AppCompatActivity() {
    private var currentPosition : Int =2
    val sliderModel=ArrayList<SliderModel>()
    lateinit var banner : ViewPager
   lateinit var timer : Timer
    private final val DELAY_TIME : Long=3000
    private final val PERIOD_TIME : Long=3000
    var fragmentmanager : FragmentManager =supportFragmentManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_food_item)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Ahmedabad")

        banner=findViewById(R.id.slider_layout)
        toolbar_back.setOnClickListener {
           finish()
        }

        chef_detail_layout.setOnClickListener {
            startActivity(Intent(applicationContext,Chef_Detail::class.java))
        }
        val details_layout : LinearLayout=findViewById(R.id.ll_details_item_brief_detail)
        val review_layout: LinearLayout=findViewById(R.id.ll_reviews_item_brief_detail)

        val layout1 : ViewGroup.LayoutParams = details_layout.layoutParams
        val layout2 : ViewGroup.LayoutParams = review_layout.layoutParams

        val fragment = DetailsFragment()
        addFragment(fragment)

        Glide.with(applicationContext) .load(R.mipmap.bg_myprofile).apply(RequestOptions().circleCrop()) .into(profile_images)

        sliderModel.add(SliderModel(R.drawable.bg_food_detail))
        sliderModel.add(SliderModel(R.drawable.banner_scroll))

        sliderModel.add(SliderModel(R.drawable.bg_food_detail))
        sliderModel.add(SliderModel(R.drawable.banner_scroll))
        sliderModel.add(SliderModel(R.drawable.bg_food_detail))
        sliderModel.add(SliderModel(R.drawable.banner_scroll))
        sliderModel.add(SliderModel(R.drawable.bg_food_detail))
        sliderModel.add(SliderModel(R.drawable.banner_scroll))

        sliderModel.add(SliderModel(R.drawable.bg_food_detail))
        sliderModel.add(SliderModel(R.drawable.banner_scroll))

        val sliderAdapter=SliderAdapter(sliderModel)
        banner.adapter=sliderAdapter
        banner.clipToPadding=false
        banner.pageMargin=20
        banner.adapter=sliderAdapter

        banner.addOnPageChangeListener(object : ViewPager.OnPageChangeListener{
            override fun onPageScrollStateChanged(state: Int) {
               if(state == ViewPager.SCROLL_STATE_IDLE)
               {
                   pageLooper()
               }
            }

            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {

            }

            override fun onPageSelected(position: Int) {
                currentPosition=position
            }
        })

        startBannerSlideshow()

        banner.setOnTouchListener(object : View.OnTouchListener{
            override fun onTouch(v: View?, event: MotionEvent?): Boolean {
                pageLooper()

                if(event?.action == MotionEvent.ACTION_UP)
                {
                    startBannerSlideshow()
                }
                if(event?.action == MotionEvent.ACTION_DOWN)
                {
                    stopBannerSlidshow()
                }
                return v?.onTouchEvent(event) ?: true
            }
        })

        var quantity_txt : TextView=findViewById(R.id.quantity)
        var count : Int=0
        plusBtn.setOnClickListener {
            count = quantity_txt.text.toString().toInt()
            count++
            quantity_txt.setText(count.toString())
        }
        minus_btn.setOnClickListener {
            count = quantity_txt.text.toString().toInt()
            count--
            quantity_txt.setText(count.toString())
        }
        //// details button

        details_layout.setOnClickListener {

            details_layout.setBackgroundResource(R.drawable.tab_detail_select)
            tv_details_title_text.setTextColor(resources.getColor(R.color.white_color))
            layout1.height=130
            details_layout.layoutParams=layout1

            review_layout.setBackgroundResource(R.drawable.tab_review_detail_unselect)
            tv_review_title_text.setTextColor(resources.getColor(R.color.black_color))
            layout2.height=121
            review_layout.layoutParams=layout2

            val fragment = DetailsFragment()
            addFragment(fragment)
        }

        review_layout.setOnClickListener {

            review_layout.setBackgroundResource(R.drawable.tab_review_select)
            tv_review_title_text.setTextColor(resources.getColor(R.color.white_color))
            layout2.height=130
            review_layout.layoutParams=layout2

            details_layout.setBackgroundResource(R.drawable.tab_review_detail_unselect)
            tv_details_title_text.setTextColor(resources.getColor(R.color.black_color))
            layout1.height=121
            details_layout.layoutParams=layout1

            val fragment = ReviewFragment()
            addFragment(fragment)
        }

        fl_btn_apply_iv.setOnClickListener {
            filter_layout.visibility=View.GONE
        }

        ll_refine.setOnClickListener {
            filter_layout.visibility=View.GONE
        }
    }
    public fun addFragment(fragment : Fragment) {
        fragmentmanager.beginTransaction().replace(R.id.frame_layout_food,fragment,fragment.javaClass.simpleName).addToBackStack(null).commit()
    }

    private fun pageLooper()
    {
        if(currentPosition == sliderModel.size -2)
        {
            currentPosition=2
            banner?.setCurrentItem(currentPosition,false)
        }
        if(currentPosition == 1)
        {
            currentPosition=sliderModel.size -3
            banner?.setCurrentItem(currentPosition,false)
        }
    }


    private fun startBannerSlideshow()
    {
        timer=Timer()
        val handler : Handler= Handler()
        val runnable : Runnable= object : Runnable {
            override fun run() {
                if(currentPosition >= sliderModel.size)
                {
                    currentPosition=1
                }
                banner?.setCurrentItem(currentPosition++,true)
            }

        }
        timer.schedule(object : TimerTask()
        {
            override fun run() {
                handler.post(runnable)
            }

        },DELAY_TIME,PERIOD_TIME)
    }

    private fun stopBannerSlidshow()
    {
        timer.cancel()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val items = item.itemId
        when(items)
        {
            R.id.filter_menu -> filter_layout.visibility=View.VISIBLE
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onBackPressed() {

    }
}