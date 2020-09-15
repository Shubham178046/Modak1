package com.example.modak.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Offer_Adapter
import com.example.modak.Model.Offer_Model
import com.example.modak.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Offers.newInstance] factory method to
 * create an instance of this fragment.
 */
class Offers : Fragment() {
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
        return inflater.inflate(R.layout.fragment_offers, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val offer_recycler : RecyclerView=view.findViewById(R.id.offer_recyclerview)

        offer_recycler.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        val offersModel=ArrayList<Offer_Model>()

        offersModel.add(Offer_Model(R.drawable.img_offer,"Get 20% Off on Grocery"))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg,"Get 50% Off & get additional 25% off"))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg1,"Up to 50% Off & get additional 25% off "))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg2,"Get 25% Off & Free Gift"))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg3,"Get 20% Off on Grocery"))
        offersModel.add(Offer_Model(R.drawable.img_offer,"Get 30% Off & get additional 15% off"))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg,"Get 20% Off on Grocery"))
        offersModel.add(Offer_Model(R.drawable.resize_offerimg1,"Get 30% Off & additional gifts"))


        val adapter=Offer_Adapter(offersModel)
        offer_recycler.adapter=adapter

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Offers.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Offers().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}