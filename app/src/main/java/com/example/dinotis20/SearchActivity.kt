package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText

class SearchActivity : AppCompatActivity() {

    private lateinit var searchEditText : EditText
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        searchEditText = findViewById(R.id.src_edt_search)
        searchEditText.requestFocus()
    }
}