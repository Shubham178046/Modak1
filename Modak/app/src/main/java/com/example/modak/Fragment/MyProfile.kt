package com.example.modak.Fragment

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.modak.Adapter.Myprofile_Adapter
import com.example.modak.Model.MyProfile_Model
import com.example.modak.R
import com.example.modak.ui.Change_Password_Activity
import com.example.modak.ui.Select_City
import kotlinx.android.synthetic.main.fragment_my_profile.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [MyProfile.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyProfile : Fragment() {
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
        return inflater.inflate(R.layout.fragment_my_profile, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        change_password_layout.setOnClickListener {
            startActivity(Intent(context,Change_Password_Activity::class.java))
        }

        location_txt.setOnClickListener {
            startActivity(Intent(context,Select_City::class.java))
        }


        myprofile_recyclerview.layoutManager= LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false)
        val myprofileModel = ArrayList<MyProfile_Model>()

        myprofileModel.add(MyProfile_Model(R.mipmap.img_favourite))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order1))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_favourite))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order1))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_favourite))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order))
        myprofileModel.add(MyProfile_Model(R.mipmap.img_review_order1))

        val adapter= Myprofile_Adapter(myprofileModel)
        myprofile_recyclerview.adapter=adapter


    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment MyProfile.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            MyProfile().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}