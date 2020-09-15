package com.example.modak.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.ItemDetailAdapter
import com.example.modak.Model.ItemDetailModel
import com.example.modak.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ReviewFragment.newInstance] factory method to
 * create an instance of this fragment.
 */

private val itemDetailModel = ArrayList<ItemDetailModel>()
class ReviewFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_review, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        val item_recyclerview : RecyclerView =view.findViewById(R.id.item_recyclerview)
        item_recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Kristijan Binski", 3.5F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Mark Henry", 2.5F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Robert Dawney Jr", 4.5F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Captain jack", 5.0F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Rock Mark", 2.0F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Illena Marco", 4.0F," Wow it looks nice super tasty, I am gonna try it~!"))
        itemDetailModel.add(ItemDetailModel(R.mipmap.bg_myprofile,"Binski Serlin", 2.5F," Wow it looks nice super tasty, I am gonna try it~!"))
       val itemDetailAdapter=ItemDetailAdapter(itemDetailModel)
        item_recyclerview.adapter= itemDetailAdapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ReviewFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ReviewFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}