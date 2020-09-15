package com.example.modak.Fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.modak.Adapter.Faq_Adapter
import com.example.modak.R
import com.example.modak.ui.Home_Navigation
import kotlinx.android.synthetic.main.fragment_help.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [Help.newInstance] factory method to
 * create an instance of this fragment.
 */
class Help : Fragment(){
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
        return inflater.inflate(R.layout.fragment_help, container, false)


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val reason_spinner: Spinner = view.findViewById(R.id.reason_sppinner)
        val reason = ArrayList<String>()

        reason.add("Select Reason")
        reason.add("Bad Quality Food")
        reason.add("Junk Food")
        reason.add("Dry Food")
        reason.add("Dirty Food")
        reason.add("Timing Problem")
        reason.add("Delivery Problem")
        reason.add("Payment Problem")

        var arrayAdapter: ArrayAdapter<String> = ArrayAdapter(view.context,android.R.layout.simple_spinner_item,reason)
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
        reason_spinner.adapter=arrayAdapter

        notification_submit_btn.setOnClickListener {
            val comment_edt : EditText=view.findViewById(R.id.comment_edt)
            if(reason_spinner.selectedItemPosition == 0)
            {
                Toast.makeText(context,"Please Select Reason",Toast.LENGTH_LONG).show()
            }
           else if(comment_edt.text.toString().trim().isEmpty())
            {
                comment_edt.error="Field Not Should Be Blank"
            }
            else
            {
                startActivity(Intent(context,Home_Navigation::class.java))
            }
        }

        val recyclerview : RecyclerView=view.findViewById(R.id.faq_recyclerview)

        recyclerview.layoutManager=LinearLayoutManager(context,LinearLayoutManager.VERTICAL,false)

        val adapter= Faq_Adapter()

        recyclerview.adapter=adapter
    }
    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment Help.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            Help().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
    private fun Fragment.getView(position: Int, convertView: View?, parent: ViewGroup?): View? {
        val view = getView(position, convertView, parent)
        view?.setPadding(0,view?.paddingTop,view?.paddingRight,view?.paddingBottom)
        return view
    }
}



