package com.example.modak.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.WindowManager
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_edit__profile.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.custom_appbar.*

class Edit_Profile : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit__profile)
       supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_appbar)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)
        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)
       // var toolbar : Toolbar =findViewById(R.id.review_toolbar)
        //toolbars.setNavigationIcon(R.mipmap.icon_back_nevi)

//        toolbars.setNavigationOnClickListener({
//            startActivity(Intent(applicationContext,Home_Navigation::class.java))
//        })
        Glide .with(this) .load(R.mipmap.bg_myprofile).apply(RequestOptions().circleCrop()) .into(edit_profile_image)
        back_icon.setOnClickListener(
            {
                startActivity(Intent(applicationContext,Home_Navigation::class.java))
                finish()
            }
        )

        close_menu.setOnClickListener {
            startActivity(Intent(applicationContext,Home_Navigation::class.java))
            finish()
        }

        save_btn.setOnClickListener {
            if(edtfirstname_profile.text.toString().trim().isEmpty())
            {
                edtfirstname_profile.error="Field Not Should Be blank"
            }
            else if(edtlastname_profile.text.toString().trim().isEmpty())
            {
                edtlastname_profile.error="Field Not Should Be blank"
            }
           else if(edt_address1.text.toString().trim().isEmpty())
            {
                edt_address1.error="Field Not Should Be blank"
            }
           else if(edt_address2.text.toString().trim().isEmpty())
            {
                edt_address2.error="Field Not Should Be blank"
            }
            else if(edt_city.text.toString().trim().isEmpty())
            {
                edt_city.error="Field Not Should Be blank"
            }
            else if(edt_state.text.toString().trim().isEmpty())
            {
                edt_state.error="Field Not Should Be blank"
            }
           else if(edt_profile_zipcode.text.toString().trim().isEmpty())
            {
                edt_profile_zipcode.error="Field Not Should Be blank"
            }
            else
            {
                startActivity(Intent(applicationContext,Home_Navigation::class.java))
            }
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.edit_profile_menu,menu)
        return true
    }
    override fun onBackPressed() {
        startActivity(Intent(applicationContext,Home_Navigation::class.java))
        finish()
    }
}