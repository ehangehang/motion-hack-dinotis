package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_home.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {
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
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        frag_home_edt_search?.setOnFocusChangeListener { _, hasFocus ->
            if (hasFocus) {
                startActivity(Intent(view.context, SearchActivity::class.java))
                frag_home_edt_search.clearFocus()
            }
        }
        
        /*frag_home_edt_search?.setOnClickListener {
            startActivity(Intent(view.context, SearchActivity::class.java))
        }*/

        frag_home_lyt_schedule?.setOnClickListener {
            startActivity(Intent(view.context, ScheduleActivity::class.java))
        }

        frag_home_lyt_category?.setOnClickListener {
            startActivity(Intent(view.context, CategoryActivity::class.java))
        }

        frag_home_lyt_meet?.setOnClickListener {
            startActivity(Intent(view.context, MeetActivity::class.java))
        }

        frag_home_lyt_wallet?.setOnClickListener {
            startActivity(Intent(view.context, WalletActivity::class.java))
        }

        frag_home_bt_notif?.setOnClickListener {
            startActivity(Intent(view.context, NotificationActivity::class.java))
        }

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment HomeFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            HomeFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}