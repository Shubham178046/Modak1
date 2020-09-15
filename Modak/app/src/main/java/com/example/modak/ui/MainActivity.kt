package com.example.modak.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.content.pm.Signature
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.util.Base64
import android.util.Log
import android.view.View
import android.view.WindowManager
import androidx.annotation.RequiresApi
import com.bumptech.glide.Glide
import com.example.modak.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.navigation_header.*
import java.security.MessageDigest
import java.security.NoSuchAlgorithmException
import java.util.*

class MainActivity : AppCompatActivity() {



    private val SPLASH_TIME_OUT:Long = 5000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler().postDelayed({

            startActivity(Intent(applicationContext,Login::class.java))
            //finish()

        },SPLASH_TIME_OUT)

        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN)

        window.decorView.apply {

           systemUiVisibility= View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
       }

        printKeyhash()
    }

    private fun printKeyhash() {
        try {
            val info =
                packageManager.getPackageInfo("com.example.modak", PackageManager.GET_SIGNATURES)
            for (signature in info.signatures)
            {
                val md=MessageDigest.getInstance("SHA")
                md.update(signature.toByteArray())
                Log.e("KEYHASH",Base64.encodeToString(md.digest(),Base64.DEFAULT) )
            }
        }
        catch (e:PackageManager.NameNotFoundException)
        {
            Log.e("Error", "printKeyhash: "+ e.toString() )
        }
        catch (e : NoSuchAlgorithmException)
        {
            Log.e("Error", "printKeyhash: "+ e.toString() )
        }
        }

}
