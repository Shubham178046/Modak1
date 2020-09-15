package com.example.modak.Fragment

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.Toolbar
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Payment_Adapter
import com.example.modak.Model.Payment_Model
import com.example.modak.R
import com.example.modak.ui.Add_Payment_Mode
import kotlinx.android.synthetic.main.toolbar_layout.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Payment.newInstance] factory method to
 * create an instance of this fragment.
 */
var result : String?=null
var result1 : String? = null
val paymentModel =ArrayList<Payment_Model>()
val paymentAdapter= Payment_Adapter(paymentModel)
class Payment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
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
        return inflater.inflate(R.layout.fragment_payment, container, false)
        Log.d("Data", "CreatedView: "+ result.toString()+" "+ result1.toString())


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setHasOptionsMenu(true)

        val recycler_view : RecyclerView =view.findViewById(R.id.payment_recyclerviews)
        recycler_view.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)


        paymentModel.add(Payment_Model(R.drawable.visa_card,"**** **** **** **1245",""))
        paymentModel.add(Payment_Model(R.drawable.visa_debit,"**** **** **** **1245",""))
        paymentModel.add(Payment_Model(R.drawable.google_wallet,"Google Wallet",""))
        paymentModel.add(Payment_Model(R.drawable.paytm,"Paytm Wallet","\u20B9"+ "0.00"))
        paymentModel.add(Payment_Model(R.drawable.apple_wallet,"Apple Pay",""))
        paymentModel.add(Payment_Model(R.drawable.cash,"Cash",""))

        recycler_view.adapter=paymentAdapter

    }

   override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.payment_menu,menu)
       menu.findItem(R.id.search_menu).setVisible(false)
       menu.findItem(R.id.filter_menu).setVisible(false)
       menu.findItem(R.id.cart_menu).setVisible(false)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        var items : Int = item.itemId
        when(items)
        {
            R.id.add_card -> {
                var intent : Intent= Intent(context,Add_Payment_Mode::class.java)
                startActivityForResult(intent,1)
            }
        }
        return super.onOptionsItemSelected(item)
    }
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode,resultCode,data)
        if(requestCode == 1)
        {
            if(resultCode == Activity.RESULT_OK)
            {
                result = data?.getStringExtra("card_type")
                result1=data?.getStringExtra("card_name")
                Log.d("Result", "onActivityResult: "+ result.toString()+" "+ result1.toString())

                if(result.equals("Visa"))
                {
                    paymentModel.add(Payment_Model(R.drawable.visa_card,result1.toString(),""))
                }
                else if(result.equals("Master"))
                {
                    paymentModel.add(Payment_Model(R.drawable.bt_ic_mastercard,result1.toString(),""))
                }
                else if(result.equals("American"))
                {
                    paymentModel.add(Payment_Model(R.drawable.bt_ic_amex,result1.toString(),""))
                }
                else if(result.equals("Cash"))
                {
                    paymentModel.add(Payment_Model(R.drawable.cash,"Cash",""))
                }
                else if(result.equals("Discover"))
                {
                    paymentModel.add(Payment_Model(R.drawable.bt_ic_discover,result1.toString(),""))
                }
                else if(result.equals("UnionPay"))
                {
                    paymentModel.add(Payment_Model(R.drawable.bt_ic_discover,result1.toString(),""))
                }
                else if(result.equals("Google Pay"))
                {
                    paymentModel.add(Payment_Model(R.drawable.google_wallet,"Google Wallet",""))
                }
                else if(result.equals("Paytm"))
                {
                    paymentModel.add(Payment_Model(R.drawable.paytm,"Paytm Wallet","\u20B9"+ "0.00"))
                }
                else if(result.equals("Apple Pay"))
                {
                    paymentModel.add(Payment_Model(R.drawable.apple_wallet,"Apple Wallet",""))
                }

                paymentAdapter.notifyDataSetChanged()
            }
            if(resultCode == Activity.RESULT_CANCELED)
            {
                Log.d("Result", "onActivityResult: " + "Error While Receiveing data")
            }
        }
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Payment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Payment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}