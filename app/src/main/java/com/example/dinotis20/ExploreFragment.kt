package com.example.dinotis20

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.adapter.LiveAdapter
import com.example.dinotis20.adapter.LiveBannerAdapter
import com.example.dinotis20.adapter.MeetingScheduleBannerAdapter
import com.example.dinotis20.helper.MeetingRetrofitHelper
import com.example.dinotis20.`interface`.ApiInterface
import com.example.dinotis20.model.Meeting

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ExploreFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ExploreFragment : Fragment() {
    private lateinit var rvCreators : RecyclerView
    private lateinit var rvDetails : RecyclerView
    private lateinit var rvCreatorsAdapter : LiveAdapter
    private lateinit var rvDetailsAdapter : LiveBannerAdapter
    private var listMeeting = emptyList<Meeting>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_explore, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        rvCreators = view.findViewById(R.id.frag_explore_rv_creator)
        rvDetails = view.findViewById(R.id.frag_explore_rv_details)

        val meetingApi = MeetingRetrofitHelper.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            val result = meetingApi.getMeeting(10)
            if (result.isSuccessful) {
                listMeeting = result.body()!!.meetings
                Log.d("", result.body().toString())

                rvCreatorsAdapter = LiveAdapter(listMeeting)
                rvCreators.adapter = rvCreatorsAdapter
                rvCreators.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)

                rvDetailsAdapter = LiveBannerAdapter(listMeeting)
                rvDetails.adapter = rvDetailsAdapter
                rvDetails.layoutManager = LinearLayoutManager(requireContext())
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
         * @return A new instance of fragment ExploreFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ExploreFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}