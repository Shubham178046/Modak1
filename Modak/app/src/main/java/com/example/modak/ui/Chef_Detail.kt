package com.example.modak.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.View
import androidx.appcompat.app.ActionBar
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.ItemDetailAdapter
import com.example.modak.Adapter.MenuChoiceAdapter
import com.example.modak.Adapter.Menu_List_Adapter
import com.example.modak.Model.ItemDetailModel
import com.example.modak.Model.MenuChoiceModel
import com.example.modak.Model.Menu_List_Model
import com.example.modak.R
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import kotlinx.android.synthetic.main.activity_sample.*
import kotlinx.android.synthetic.main.custom_toolbar.*

class Chef_Detail : AppCompatActivity(), OnMapReadyCallback {
    private lateinit var mMap: GoogleMap
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chef__detail)
        supportActionBar?.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM)
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.custom_toolbar)
        setSupportActionBar(toolbar_custom)
        supportActionBar?.title=null
        toolbar_title.setText("Ahmedabad")


        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        tv_read_more.setOnClickListener {
            tv_chef_detail2_chef_detail.visibility = View.VISIBLE
            tv_read_more.visibility = View.GONE
        }

        toolbar_back.setOnClickListener {
            super.onBackPressed()
        }
        ll_review_choice_chef.setOnClickListener {

            iv_review_choice_chef.setImageResource(R.drawable.icon_review_selected)
            tv_review_choice_chef.setTextColor(resources.getColor(R.color.red_color))

            iv_share_choice_chef.setImageResource(R.drawable.icon_share)
            tv_share_choice_chef.setTextColor(resources.getColor(R.color.Light_black))

            iv_rate_choice_chef.setImageResource(R.drawable.icon_rate)
            tv_rate_choice_chef.setTextColor(resources.getColor(R.color.Light_black))

            iv_menu_choice_chef.setImageResource(R.drawable.icon_menu_chef_detail)
            tv_menu_choice_chef.setTextColor(resources.getColor(R.color.Light_black))


            review_ll_chef_detail.visibility=View.VISIBLE
            menu_choicescroll.visibility=View.GONE
            review_ll.visibility=View.GONE
            menu_list_ll.visibility=View.GONE
            val recyclerView : RecyclerView =findViewById(R.id.reviewlist_chef_detail)

            recyclerView.layoutManager=
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL,false)
            val itemDetailModel = ArrayList<ItemDetailModel>()
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Kristijan Binski", 3.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Mark Henry", 2.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Robert Dawney Jr", 4.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Captain jack", 5.0F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Rock Mark", 2.0F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Illena Marco", 4.0F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Binski Serlin", 2.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Kristijan Binski", 3.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Mark Henry", 2.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Robert Dawney Jr", 4.5F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Captain jack", 5.0F," Wow it looks nice super tasty, I am gonna try it~!"))
            itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Rock Mark", 2.0F," Wow it looks nice super tasty, I am gonna try it~!"))

            val itemDetailAdapter= ItemDetailAdapter(itemDetailModel)
            recyclerView.adapter=itemDetailAdapter
        }

        ll_menu_choice_chef.setOnClickListener {
            iv_review_choice_chef.setImageResource(R.drawable.icon_review)
            tv_review_choice_chef.setTextColor(resources.getColor(R.color.Light_black))

            iv_share_choice_chef.setImageResource(R.drawable.icon_share)
            tv_share_choice_chef.setTextColor(resources.getColor(R.color.Light_black))

            iv_rate_choice_chef.setImageResource(R.drawable.icon_rate)
            tv_rate_choice_chef.setTextColor(resources.getColor(R.color.Light_black))

            iv_menu_choice_chef.setImageResource(R.drawable.icon_menu_chef_detail_selected)
            tv_menu_choice_chef.setTextColor(resources.getColor(R.color.red_color))

            menu_choicescroll.visibility = View.VISIBLE
            review_ll.visibility = View.VISIBLE
            review_layout.visibility = View.GONE
            review_layout_1.visibility = View.GONE
            review_layout_2.visibility = View.GONE
            menu_list_ll.visibility = View.GONE

            val recyclerView: RecyclerView = findViewById(R.id.reviewlist2)
            recyclerView.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            val menuChoiceModel = ArrayList<MenuChoiceModel>()

            menuChoiceModel.add(MenuChoiceModel(R.drawable.img_menu1, "Breakfast"))
            menuChoiceModel.add(MenuChoiceModel(R.drawable.img_menu2, "Lunch"))
            menuChoiceModel.add(MenuChoiceModel(R.drawable.img_menu3, "Dinner"))

            val adapter = MenuChoiceAdapter(menuChoiceModel, object : MenuChoiceAdapter.OnClick {
                override fun onClick() {
                    menu_choicescroll.visibility = View.GONE
                    review_ll_chef_detail.visibility = View.GONE
                    review_ll.visibility = View.GONE
                    menu_list_ll.visibility = View.VISIBLE
                }

            })

            recyclerView.adapter = adapter


            //// menu icon selected

            val menu_recyclerview: RecyclerView = findViewById(R.id.menulistview)
            menu_recyclerview.layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)

            val menuListModel = ArrayList<Menu_List_Model>()
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.bg_food_detail,
                    "Green capsicum pepped up with Cheese and spices",
                    "22.00",
                    "2"
                )
            )
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.img_menu2,
                    "Green capsicum pepped",
                    "23.00",
                    "1"
                )
            )
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.img_menu3,
                    "Green capsicum with Cheese and spices",
                    "24.00",
                    "3"
                )
            )
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.img_menu1,
                    "pepped up with Cheese and spices",
                    "21.00",
                    "4"
                )
            )
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.bg_food_detail,
                    "Cheese and spices with Green capsicum",
                    "22.00",
                    "3"
                )
            )
            menuListModel.add(
                Menu_List_Model(
                    R.drawable.img_menu2,
                    "pepped up Green capsicum with Cheese and spices",
                    "23.00",
                    "1"
                )
            )

            val menuListAdapter = Menu_List_Adapter(menuListModel)

            menu_recyclerview.adapter = menuListAdapter

            /// menu choices click event

            ll_dine_in.setOnClickListener {
                iv_dine_in_select.setImageResource(R.mipmap.icon_dinein_selected)
                dinein_txt.setTextColor(resources.getColor(R.color.red_color))
                iv_dine_in_check.setImageResource(R.mipmap.chacked_breakfast_list)

                iv_takeout_select.setImageResource(R.mipmap.icon_takeout_unselected)
                takeout_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_takeout_check.setImageResource(R.mipmap.unchacked_breakfast_list)

                iv_delivery_select.setImageResource(R.mipmap.icon_delivery_unselected)
                delivery_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_delivery_check.setImageResource(R.mipmap.unchacked_breakfast_list)
            }

            ll_takeout.setOnClickListener {

                iv_dine_in_select.setImageResource(R.mipmap.icon_dinein_unselected)
                dinein_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_dine_in_check.setImageResource(R.mipmap.unchacked_breakfast_list)

                iv_takeout_select.setImageResource(R.mipmap.icon_takeout_selected)
                takeout_txt.setTextColor(resources.getColor(R.color.red_color))
                iv_takeout_check.setImageResource(R.mipmap.chacked_breakfast_list)

                iv_delivery_select.setImageResource(R.mipmap.icon_delivery_unselected)
                delivery_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_delivery_check.setImageResource(R.mipmap.unchacked_breakfast_list)
            }

            ll_delivery.setOnClickListener {
                iv_dine_in_select.setImageResource(R.mipmap.icon_dinein_unselected)
                dinein_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_dine_in_check.setImageResource(R.mipmap.unchacked_breakfast_list)

                iv_takeout_select.setImageResource(R.mipmap.icon_takeout_unselected)
                takeout_txt.setTextColor(resources.getColor(R.color.grey_color))
                iv_takeout_check.setImageResource(R.mipmap.unchacked_breakfast_list)

                iv_delivery_select.setImageResource(R.mipmap.icon_delivery_selected)
                delivery_txt.setTextColor(resources.getColor(R.color.red_color))
                iv_delivery_check.setImageResource(R.mipmap.chacked_breakfast_list)
            }
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLng(sydney))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.action_bar_menu,menu)
        return true
    }

    override fun onBackPressed() {

    }
}