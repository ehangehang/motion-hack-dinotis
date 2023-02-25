package com.example.dinotis20

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class ChosenCreatorActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView

    private fun init() {
        btBack = findViewById(R.id.subs_bt_back)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chosen_creator)

        init()

        btBack.setOnClickListener {
            finish()
        }
    }
}