package com.example.modak.Fragment

import android.content.res.ColorStateList
import android.graphics.Color.red
import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.MyOrder_Adapter
import com.example.modak.Model.MyOrders_Model
import com.example.modak.R
import kotlinx.android.synthetic.main.fragment_my_orders.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyOrders.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyOrders : Fragment()  {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_orders, container, false)
    }



    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        val card_type: String=this.arguments?.getString("card_type").toString()
        val card_name_number: String=this.arguments?.getString("card_name").toString()

        Log.d("Card Type", "onViewCreated: "+card_type.toString())
        Log.d("Card Number", "onViewCreated: "+card_name_number.toString())

        val recycler_view : RecyclerView=view.findViewById(R.id.my_orders_recyclerview)
        val past_orders_recyclewrview : RecyclerView=view.findViewById(R.id.past_order_recyclerview)

        val current_btn : Button =view.findViewById(R.id.current_orders)
        val past_order : Button=view.findViewById(R.id.past_orders)

        recycler_view.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)
        past_orders_recyclewrview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        recycler_view.visibility=View.VISIBLE
        //////// Current orders Recyclerview
        val myordersModel=ArrayList<MyOrders_Model>()

        myordersModel.add(MyOrders_Model("Order Id: #MG56986","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MN325698","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MG56986","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MN325698","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #MG56986","$25.00","31/08/2015",1))
        myordersModel.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",1))


        val adapter=MyOrder_Adapter(myordersModel)
        recycler_view.adapter=adapter

        //////// Past orders Recyclerview

        val myordersModel1=ArrayList<MyOrders_Model>()

        myordersModel1.add(MyOrders_Model("Order Id: #MG56986","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MN325698","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MG56986","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MN325698","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #BG58963","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MN325698","$25.00","31/08/2015",0))
        myordersModel1.add(MyOrders_Model("Order Id: #MA25998","$25.00","31/08/2015",0))

        val adapter1=MyOrder_Adapter(myordersModel1)
        past_orders_recyclewrview.adapter=adapter1

        current_btn.setOnClickListener {
            //current_btn.backgroundTintList=context.resources.getColor(R.color.red_color)
            current_btn.backgroundTintList=ColorStateList.valueOf(resources.getColor(R.color.red_color))
            current_btn.setTextColor(resources.getColor(R.color.white_color))

            past_orders.backgroundTintList=null
            past_orders.setTextColor(resources.getColor(R.color.grey_color))

            past_orders_recyclewrview.visibility=View.GONE
            recycler_view.visibility=View.VISIBLE

        }

        past_order.setOnClickListener {
            past_orders.backgroundTintList=ColorStateList.valueOf(resources.getColor(R.color.red_color))
            past_orders.setTextColor(resources.getColor(R.color.white_color))

            current_btn.backgroundTintList=null
            current_btn.setTextColor(resources.getColor(R.color.grey_color))

            recycler_view.visibility=View.GONE
            past_orders_recyclewrview.visibility=View.VISIBLE
        }


    }



    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyOrders.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyOrders().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }


}