package com.example.modak.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Dish_item_Adapter
import com.example.modak.Model.dish_item_model
import com.example.modak.R

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Favorite.newInstance] factory method to
 * create an instance of this fragment.
 */
class Favorite : Fragment() {
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
        return inflater.inflate(R.layout.fragment_favorite, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView : RecyclerView =view.findViewById(R.id.favorite_recyclerview)
        recyclerView.layoutManager= LinearLayoutManager(context, LinearLayoutManager.VERTICAL,false)

        val dishItemModel = ArrayList<dish_item_model>()
        dishItemModel.add(dish_item_model(R.drawable.icon_like,R.mipmap.bg_myprofile,"Chef Dazzy Peter","1 mile away","$25.00","3"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like1,R.mipmap.imgwomen,"Chef Dazzy Peter","2 mile away","$25.00","3"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like,R.mipmap.bg_myprofile,"Peter Dazzy Chef","1 mile away","$25.00","3"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like1,R.mipmap.imgwomen,"Chef Dazzy Peter","2 mile away","$25.00","2"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like,R.mipmap.bg_myprofile,"Peter Dazzy Chef","3 mile away","$25.00","3"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like1,R.mipmap.imgwomen,"Peter Dazzy Chef","1 mile away","$25.00","3"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like,R.mipmap.bg_myprofile,"Chef Dazzy Peter","2 mile away","$25.00","2"))
        dishItemModel.add(dish_item_model(R.drawable.icon_like1,R.mipmap.imgwomen,"Chef Dazzy Peter","1 mile away","$25.00","3"))


        val adapter = Dish_item_Adapter(dishItemModel)
        recyclerView.adapter=adapter
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Favorite.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Favorite().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}