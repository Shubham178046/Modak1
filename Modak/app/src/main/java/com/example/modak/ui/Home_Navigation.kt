package com.example.modak.ui

import android.content.Intent
import android.graphics.Typeface
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.annotation.RequiresApi
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.modak.Fragment.DeliveryFragment
import com.example.modak.Fragment.DineOut
import com.example.modak.Fragment.Favorite
import com.example.modak.Fragment.*
import com.example.modak.R
import com.example.modak.header.SessionManagement
import com.facebook.AccessToken
import com.facebook.GraphRequest
import com.facebook.HttpMethod
import com.facebook.login.LoginManager
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.appbar_layout.*
import kotlinx.android.synthetic.main.appbar_layout.toolbar

class Home_Navigation : AppCompatActivity() /* FragmentManager.OnBackStackChangedListener*/ {

    var fragmentmanager : FragmentManager=supportFragmentManager
    var ft : FragmentTransaction=supportFragmentManager.beginTransaction()
    var flag : Int=0
    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home__navigation)
        setSupportActionBar(toolbar)
//      val actionbar=supportActionBar
//        actionbar?.title= "Ahmedabad"
     //  val drawerToggle :ActionBarDrawerToggle = object : ActionBarDrawerToggle( this,drawer_layout,toolbar1,(R.string.open),(R.string.close))
//
//
//        drawerToggle.isDrawerIndicatorEnabled=true
//        drawer_layout.addDrawerListener(drawerToggle)
//        drawerToggle.syncState()
        //val image_view=findViewById<ImageView>(R.id.profile_image)
       /* Glide.with(this)
            .load(R.drawable.btn_fb)
            .into(profile_image)*/
        flag=1
            val intent= intent
            val key = intent.getStringExtra("key")
        Log.d("Key", "onCreate: "+ key?.toString())
        if(key?.toString().equals("access"))
        {
            val fragment=Payment()
            addFragment(fragment)
           toolbar.title="Payments"
            gps_icon.visibility=View.INVISIBLE
            main_layout.visibility=View.GONE
        }
        else
        {
            val fragment= Favorite()
            addFragment(fragment)
        }



        var drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        var navView = findViewById<NavigationView>(R.id.navigation_view)
        var linearLayout : LinearLayout=findViewById(R.id.hone_layout)

       // var relativeLayout : RelativeLayout=findViewById(R.id.main_relative_layout)

        navView.isVerticalScrollBarEnabled=false

        //// google signout

        val gso =
            GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        navView.setNavigationItemSelectedListener(NavigationView.OnNavigationItemSelectedListener { item ->
            when(item.itemId)
            {
                R.id.menu1 ->
                {

                    startActivity(Intent(applicationContext,Home_Navigation::class.java))
                    flag=1
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    return@OnNavigationItemSelectedListener true
                }

                R.id.menu2 ->
                {

                    val fragment=MyProfile()
                    addFragment(fragment)
                    toolbar.title="My Profile"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    main_layout.visibility=View.GONE
                    flag=0
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu3 ->
                {
                    val fragment=MyAddress()
                    addFragment(fragment)
                    toolbar.title="My Address"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    main_layout.visibility=View.GONE
                    flag=0
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu4 ->
                {
                    val fragment=Payment()
                    addFragment(fragment)
                    toolbar.title="Payments"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(true)
                    gps_icon.visibility=View.INVISIBLE
                    main_layout.visibility=View.GONE
                    flag=0
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu5 ->
                {
                    val fragment=Notification()
                    addFragment(fragment)
                    toolbar.title="Notifications"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    main_layout.visibility=View.GONE
                    flag=0
                    drawerLayout.closeDrawers()

                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu6 ->
                {
                    val fragment=Offers()
                    addFragment(fragment)
                    toolbar.title="Offers"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    main_layout.visibility=View.GONE
                    flag=0
                    drawerLayout.closeDrawers()

                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu7 ->
                {
                    val fragment=Setting()
                    addFragment(fragment)
                    toolbar.title="Settings"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    flag=0
                    main_layout.visibility=View.GONE
                    drawerLayout.closeDrawers()

                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu8 ->
                {
                    val fragment=Help()
                    addFragment(fragment)
                    toolbar.title="Help"
                    toolbar.menu.findItem(R.id.search_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
                    toolbar.menu.findItem(R.id.add_cards).setVisible(false)
                    gps_icon.visibility=View.INVISIBLE
                    flag=0
                    main_layout.visibility=View.GONE
                    drawerLayout.closeDrawers()
                    return@OnNavigationItemSelectedListener true
                }
                R.id.menu9 ->
                {
                    //startActivity(Intent(applicationContext,Login::class.java))
                    //facebookLogout()
                    googleLogout(gso)
                    logout()
                    finish()
                    return@OnNavigationItemSelectedListener true
                }
                else -> false
            }
        })
        gps_icon.setOnClickListener {
            startActivity(Intent(applicationContext,Select_City::class.java))
        }

        var headerview : View = navView.getHeaderView(0)

        var header_image : ImageView=headerview.findViewById(R.id.profile_image)
        var title_name : TextView=headerview.findViewById<TextView>(R.id.title_1)
            title_name.setText("My Orders")

        var review_activity_layout : LinearLayout=headerview.findViewById(R.id.navigation_header_review)
        var my_orders_layout : LinearLayout=headerview.findViewById(R.id.navigation_linear_layout)
        var edit_profile_layout : LinearLayout=headerview.findViewById(R.id.header_layout1)

        //var image : ImageView= headerview.findViewById(R.id.edit_profile_icon)

        edit_profile_layout.setOnClickListener {
            drawerLayout.closeDrawers()
            startActivity(Intent(applicationContext,Edit_Profile::class.java))
        }

        review_activity_layout.setOnClickListener {
            drawerLayout.closeDrawers()
            startActivity(Intent(applicationContext,Review_Activity::class.java))
        }

        my_orders_layout.setOnClickListener {
            val fragment=MyOrders()
            addFragment(fragment)
            toolbar.title="My Orders"
            toolbar.menu.findItem(R.id.search_menu).setVisible(false)
            toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
            toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
            toolbar.menu.findItem(R.id.add_cards).setVisible(false)
            gps_icon.visibility=View.INVISIBLE
            main_layout.visibility=View.GONE
            drawerLayout.closeDrawers()
        }
        Glide .with(this) .load(R.mipmap.bg_myprofile).apply(RequestOptions().circleCrop()) .into(header_image)
        val toggle : ActionBarDrawerToggle = object : ActionBarDrawerToggle(
            this, drawerLayout, toolbar, 0, 0
        ){
            override fun onDrawerSlide(drawerView: View, slideOffset: Float) {
                super.onDrawerSlide(drawerView, slideOffset)
                val slidex : Float= drawerView.width * slideOffset
                linearLayout.translationX=slidex
            }
        }
        //drawerLayout.setDrawerListener(drawerLayout)
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        /// bottom navigation design function call

        Bottom_Navigation_Style()

        }

    private fun logout() {
        val sessionManagement : SessionManagement= SessionManagement(applicationContext)
        sessionManagement.removeSession()
        moveToLogin()
    }
    private fun facebookLogout()
    {
        if(AccessToken.getCurrentAccessToken() != null)
        {
            GraphRequest(AccessToken.getCurrentAccessToken(),"/me/permission/",null,HttpMethod.DELETE,GraphRequest.Callback {
                AccessToken.setCurrentAccessToken(null)
                LoginManager.getInstance().logOut()
            }
            ).executeAsync()
        }
    }

    private fun googleLogout(gso : GoogleSignInOptions)
    {
        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        mGoogleSignInClient.signOut().addOnCompleteListener{
            Log.d("LOgout", "googleLogout: "+ "Google Signout Successfull")
        }
    }
    private fun moveToLogin() {
        val intent : Intent= Intent(applicationContext,Login::class.java)
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK)
        startActivity(intent)
    }
    fun paymentFragment() {
        toolbar.title="Payments"
        toolbar.menu.findItem(R.id.search_menu).setVisible(false)
        toolbar.menu.findItem(R.id.cart_menu).setVisible(false)
        toolbar.menu.findItem(R.id.filter_menu).setVisible(false)
        toolbar.menu.findItem(R.id.add_cards).setVisible(true)
        gps_icon.visibility=View.INVISIBLE
        main_layout.visibility=View.GONE
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
       /* if(flag==1)
        {
            menu?.findItem(R.id.search_menu)?.setVisible(false)
            menu?.findItem(R.id.cart_menu)?.setVisible(false)
            menu?.findItem(R.id.filter_menu)?.setVisible(false)
            main_layout.visibility=View.INVISIBLE
        }*/
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        /*var items : Int = item.itemId
        when(items)
        {
            R.id.add_cards -> {
                var intent : Intent= Intent(this,Add_Payment_Mode::class.java)
                startActivityForResult(intent,1)
            }

        }*/
        return super.onOptionsItemSelected(item)
    }

    public fun addFragment(fragment : Fragment) {
        fragmentmanager.beginTransaction().replace(R.id.frame_layout,fragment,fragment.javaClass.simpleName).addToBackStack(null).commit()
    }
    fun Bottom_Navigation_Style()
    {
        var linear_layout1 : LinearLayout =findViewById(R.id.ll_favourite_footer)
        var linear_layout2 : LinearLayout =findViewById(R.id.ll_delivery_footer)
        var linear_layout3 : LinearLayout =findViewById(R.id.ll_take_out_footer)
        var linear_layout4 : LinearLayout =findViewById(R.id.ll_dine_in_footer)

        var menu1_img : ImageView = findViewById(R.id.iv_favourite_footer)
        var menu2_img : ImageView = findViewById(R.id.iv_delivery_footer)
        var menu3_img : ImageView = findViewById(R.id.iv_take_out_footer)
        var menu4_img : ImageView = findViewById(R.id.iv_dine_in_footer)

        var menu1_txt : TextView =findViewById(R.id.tv_favorite_footer)
        var menu2_txt : TextView =findViewById(R.id.tv_delivery_footer)
        var menu3_txt : TextView =findViewById(R.id.tv_take_out_footer)
        var menu4_txt : TextView =findViewById(R.id.tv_dine_in_footer)

        menu1_txt.setTypeface(null, Typeface.BOLD)
        menu1_img.setImageResource(R.drawable.footer_icon4_selected)

        linear_layout1.setOnClickListener {

            menu1_txt.setTypeface(null, Typeface.BOLD)
            menu1_img.setImageResource(R.drawable.footer_icon4_selected)

//////        text
            menu2_txt.setTypeface(null, Typeface.NORMAL)
            menu3_txt.setTypeface(null, Typeface.NORMAL)
            menu4_txt.setTypeface(null, Typeface.NORMAL)

            ////image

            menu2_img.setImageResource(R.drawable.footer_icon3_unselected)
            menu3_img.setImageResource(R.drawable.footer_icon1_unselected)
            menu4_img.setImageResource(R.drawable.footer_icon2_unselected)

            val fragment= Favorite()
            addFragment(fragment)
            flag=1
            toolbar.menu.findItem(R.id.add_cards).setVisible(false)

        }
        linear_layout2.setOnClickListener {

            menu2_txt.setTypeface(null, Typeface.BOLD)
            menu2_img.setImageResource(R.drawable.footer_icon3_selected)


            menu1_txt.setTypeface(null, Typeface.NORMAL)
            menu3_txt.setTypeface(null, Typeface.NORMAL)
            menu4_txt.setTypeface(null, Typeface.NORMAL)

            ////image
            ////image
            menu1_img.setImageResource(R.drawable.footer_icon4_unselected)
            menu3_img.setImageResource(R.drawable.footer_icon1_unselected)
            menu4_img.setImageResource(R.drawable.footer_icon2_unselected)

            val fragment= DeliveryFragment()
            addFragment(fragment)
            flag=0
            toolbar.menu.findItem(R.id.add_cards).setVisible(false)
        }

        linear_layout3.setOnClickListener {

            menu3_txt.setTypeface(null, Typeface.BOLD)

            menu3_img.setImageResource(R.drawable.footer_icon1_selected)


            menu2_txt.setTypeface(null, Typeface.NORMAL)
            menu1_txt.setTypeface(null, Typeface.NORMAL)
            menu4_txt.setTypeface(null, Typeface.NORMAL)

            ////image

            menu2_img.setImageResource(R.drawable.footer_icon3_unselected)
            menu1_img.setImageResource(R.drawable.footer_icon4_unselected)
            menu4_img.setImageResource(R.drawable.footer_icon2_unselected)

            val fragment=TakeOut()
            addFragment(fragment)
            flag=0
            toolbar.menu.findItem(R.id.add_cards).setVisible(false)
        }
        linear_layout4.setOnClickListener {

            menu4_txt.setTypeface(null, Typeface.BOLD)

            menu4_img.setImageResource(R.drawable.footer_icon2_selected)

            menu2_txt.setTypeface(null, Typeface.NORMAL)
            menu3_txt.setTypeface(null, Typeface.NORMAL)
            menu1_txt.setTypeface(null, Typeface.NORMAL)
            ////image
            menu2_img.setImageResource(R.drawable.footer_icon3_unselected)
            menu3_img.setImageResource(R.drawable.footer_icon1_unselected)
            menu1_img.setImageResource(R.drawable.footer_icon4_unselected)

            val fragment= DineOut()
            addFragment(fragment)
            flag=0
            toolbar.menu.findItem(R.id.add_cards).setVisible(false)

        }
// val fragment : Fragment=supportFragmentManager.findFragmentById(R.id.frame_layout)
    }

    override fun onBackPressed() {

        val fragment : Fragment?=supportFragmentManager.findFragmentById(R.id.frame_layout)
        var i :Int =0
        if(flag == 0)
        {
            startActivity(Intent(applicationContext,Home_Navigation::class.java))
        }
        else
        {
            clearStack()
            val intent : Intent=Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME);
           intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TASK);
            //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or  Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent);
            finish();
        }
    }

    private fun clearStack() {
     //   var i :Int =0
//        while(i<supportFragmentManager.backStackEntryCount)
//            {
            //   supportFragmentManager.popBackStack(null, FragmentManager.POP_BACK_STACK_INCLUSIVE)
//                ++i
//            }
        val manager = supportFragmentManager
        if (manager.backStackEntryCount > 0) {
            val first =
                manager.getBackStackEntryAt(0)
            manager.popBackStack(
                first.id,
                FragmentManager.POP_BACK_STACK_INCLUSIVE
            )
        }

//        var i :Int =0
//        val backStackEntry :Int=supportFragmentManager.backStackEntryCount
//        if(backStackEntry > 0)
//        {
//
//            while (supportFragmentManager.backStackEntryCount > 0){
//                supportFragmentManager.popBackStackImmediate();
//            }
//
//        }

//        if(supportFragmentManager.fragments != null && supportFragmentManager.fragments.size > 0)
//        {
//            for(i in 0 until supportFragmentManager.fragments.size step 1 )
//            {
//                val fragment : Fragment= supportFragmentManager.fragments.get(i)
//                if(fragment != null)
//                {
//                    supportFragmentManager.beginTransaction().remove(fragment).commit()
//                }
//            }
//        }

    }

   /* override fun onBackStackChanged() {
        val backStackEntry :Int=supportFragmentManager.backStackEntryCount
        var i :Int =backStackEntry
        while(i >=0)
        {
            var backstatckentry : FragmentManager.BackStackEntry=fragmentmanager.getBackStackEntryAt(i)
            Toast.makeText(applicationContext,backstatckentry.name+"\n",Toast.LENGTH_LONG).show()
        }
    }*/
}
