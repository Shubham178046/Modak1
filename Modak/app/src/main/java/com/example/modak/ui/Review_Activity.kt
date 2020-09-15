package com.example.modak.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import androidx.core.view.get
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Adapter.Review_Adapter
import com.example.modak.Model.Review_model
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_review_.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.custom_appbar.*
import kotlinx.android.synthetic.main.review_item.*

class Review_Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_review_)

      /* var toolbar : androidx.appcompat.widget.Toolbar?=findViewById(R.id.review_toolbar)
        setSupportActionBar(toolbar)
        toolbar?.title="Review"
        toolbar?.setNavigationIcon(R.mipmap.icon_back_nevi)

        toolbar?.setNavigationOnClickListener({
            startActivity(Intent(applicationContext,Home_Navigation::class.java))
        })
*/
        //val image : ImageView =findViewById(R.id.profile_images)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_appbar)

        title_editprofilr.setText("Reviews")
        close_menu.visibility= View.INVISIBLE

        back_icon.setOnClickListener(
            {
                startActivity(Intent(applicationContext,Home_Navigation::class.java))
                finish()
            }
        )
        val recyclerView : RecyclerView=findViewById(R.id.revier_recyclerview)
        recyclerView.layoutManager=LinearLayoutManager(applicationContext,LinearLayoutManager.VERTICAL,false)
         val reviewModel = ArrayList<Review_model>()


       // var header_image : View = recyclerView.getChildItemId(R.id.profile_image)
      //  var image : ImageView=header_image.findViewById(R.id.profile_images)

       // Glide .with(this) .load(R.mipmap.bg_myprofile).apply(RequestOptions().circleCrop()) .into(image)


        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.bg_myprofile,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))
        reviewModel.add(Review_model(R.mipmap.imgwomen,"Chef Dazzy Petet","Long ipsum is dummy text of the printing and typecasting industry*","23 Feb 2014"))


        val adapter = Review_Adapter(reviewModel)
        recyclerView.adapter=adapter


    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext,Home_Navigation::class.java))
        finish()
    }
}