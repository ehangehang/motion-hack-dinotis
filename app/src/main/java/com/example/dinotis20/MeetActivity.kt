package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.viewpager2.widget.ViewPager2
import com.example.dinotis20.adapter.MeetActivityAdapter
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MeetActivity : AppCompatActivity() {

    private lateinit var viewPagerAdapter: MeetActivityAdapter
    private lateinit var viewPager: ViewPager2
    private lateinit var tabLayout: TabLayout

    private lateinit var btBack: ImageView

    private fun init() {
        viewPagerAdapter = MeetActivityAdapter(this)
        viewPager = findViewById(R.id.meet_view_pager)
        tabLayout = findViewById(R.id.meet_tab_layout)

        btBack = findViewById(R.id.meet_bt_back)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_meet)

        init()

        viewPager.adapter = viewPagerAdapter
        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            when(position) {
                0 -> tab.text = "Make Meet"
                1 -> tab.text = "History"
            }
        }.attach()

        btBack.setOnClickListener {
            finish()
        }
    }
}