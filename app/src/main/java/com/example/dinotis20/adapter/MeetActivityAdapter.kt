package com.example.dinotis20.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.dinotis20.HistoryMeetFragment
import com.example.dinotis20.MakeMeetFragment

class MeetActivityAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> MakeMeetFragment()
            1 -> HistoryMeetFragment()
            else -> MakeMeetFragment()
        }
    }
}