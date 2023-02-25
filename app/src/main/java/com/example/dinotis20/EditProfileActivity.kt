package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView

class EditProfileActivity : AppCompatActivity() {

    private lateinit var btBack: ImageView
    private lateinit var edtEmail: EditText
    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btSave: Button

    private fun init() {
        btBack = findViewById(R.id.edtprof_bt_back)
        edtEmail = findViewById(R.id.edtprof_edt_email)
        edtName = findViewById(R.id.edtprof_edt_name)
        edtPassword = findViewById(R.id.edtprof_edt_pass)
        btSave = findViewById(R.id.edtprof_bt_save)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profile)

        init()

        btBack.setOnClickListener {
            finish()
        }
    }
}