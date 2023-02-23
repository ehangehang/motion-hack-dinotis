package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class ScheduleActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView

    private fun init() {
        btBack = findViewById(R.id.schedule_bt_back)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_schedule)

        init()

        btBack.setOnClickListener {
            finish()
        }
    }
}