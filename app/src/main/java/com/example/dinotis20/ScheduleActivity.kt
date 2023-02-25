package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.ImageView
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dinotis20.adapter.MeetingScheduleAdapter
import com.example.dinotis20.adapter.MeetingScheduleBannerAdapter
import com.example.dinotis20.helper.MeetingRetrofitHelper
import com.example.dinotis20.`interface`.ApiInterface
import com.example.dinotis20.model.Meeting

class ScheduleActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView
    private lateinit var rv : RecyclerView
    private lateinit var rvAdapterScheduleBanner : MeetingScheduleBannerAdapter
    private var listAllSchedule = emptyList<Meeting>()


    private fun init() {
        btBack = findViewById(R.id.schedule_bt_back)
        rv = findViewById(R.id.schedule_rv_list)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        init()

        btBack.setOnClickListener {
            finish()
        }

        val meetingApi = MeetingRetrofitHelper.getInstance().create(ApiInterface::class.java)
        lifecycleScope.launchWhenCreated {
            val result = meetingApi.getMeeting()
            println(result.body()?.meetings)
            if (result.isSuccessful) {
                listAllSchedule = result.body()!!.meetings
                println(listAllSchedule)
                Log.d("", result.body().toString())

                rvAdapterScheduleBanner = MeetingScheduleBannerAdapter(listAllSchedule)
                rv.adapter = rvAdapterScheduleBanner
                rv.layoutManager = LinearLayoutManager(this@ScheduleActivity)
            }
        }
    }
}