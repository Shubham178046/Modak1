package com.example.modak.ui

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.Toast
import android.widget.Toolbar
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBar
import com.example.modak.Fragment.MyOrders
import com.example.modak.Fragment.MyProfile
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_change__password_.*
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.custom_appbar.*
import kotlinx.android.synthetic.main.toolbar_layout.*

class Change_Password_Activity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_change__password_)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_appbar)

        window.setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN)

        title_editprofilr.setText("Change Password")
        close_menu.visibility = View.INVISIBLE

        back_icon.setOnClickListener(
            {
                // startActivity(Intent(applicationContext,Home_Navigation::class.java))
                super.onBackPressed()
            }
        )
        change_password_btn.setOnClickListener {
            if (edt_change_password.text.toString().trim().isEmpty()) {
                edt_change_password.error = "Field Not Should Be Blank"
            } else if (edt_new_password.text.toString().trim().isEmpty()) {
                edt_new_password.error = "Field Not Should Be Blank"
            } else if (edt_confirm_password.text.toString().trim().isEmpty()) {
                edt_confirm_password.error = "Field Not Should Be Blank"
            } else if (!(edt_new_password.text.toString().trim()
                    .equals(edt_confirm_password.text.toString().trim()))
            ) {
                Toast.makeText(
                    applicationContext,
                    "Confirm Password Not Match With New Password",
                    Toast.LENGTH_LONG
                ).show()
            }
            else
            {
              startActivity(Intent(applicationContext,Home_Navigation::class.java))
            }

        }
    }

    override fun onBackPressed() {
        startActivity(Intent(applicationContext,Home_Navigation::class.java))
    }
}