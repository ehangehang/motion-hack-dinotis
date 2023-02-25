package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class PickRoleActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView

    private fun init() {
        btBack = findViewById(R.id.pickrole_bt_back)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pick_role)

        init()

        btBack.setOnClickListener {
            finish()
        }
    }
}