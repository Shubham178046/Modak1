package com.example.modak.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Address_Adapter
import com.example.modak.Model.Address_Model
import com.example.modak.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Address_List.newInstance] factory method to
 * create an instance of this fragment.
 */
lateinit var adapter: Address_Adapter

class Address_List : Fragment() {
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
        return inflater.inflate(R.layout.fragment_address__list, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView=view.findViewById(R.id.address_list_recyclerview)
        val list= ArrayList<Address_Model>()

        list.add(Address_Model("Home","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",true))
        list.add(Address_Model("Office","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 1","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 2","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 3","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))
        list.add(Address_Model("Address 4","350 Fifth Avenue, 34th floor New York,NY 10118-3299 USA",false))

        recyclerView.layoutManager= LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        adapter=Address_Adapter(list)
        recyclerView.adapter=adapter
        adapter.notifyDataSetChanged()
    }
    public fun refreshItem(select: Int, deselect: Int)
    {

            adapter.notifyItemChanged(deselect)
          adapter.notifyItemChanged(select)
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Address_List.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Address_List().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}