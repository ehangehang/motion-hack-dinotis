package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class NotificationActivity : AppCompatActivity() {

    private lateinit var btBack : ImageView

    fun init() {
        btBack = findViewById(R.id.notification_bt_back)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        init()

        btBack.setOnClickListener {
            finish()
        }
    }
}