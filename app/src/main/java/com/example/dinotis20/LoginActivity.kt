package com.example.dinotis20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    // Firebase
    private lateinit var auth: FirebaseAuth

    // variables
    private var phoneNumber = "+62"

    // elements
    private val edtEmail = findViewById<EditText>(R.id.lg_edt_email)
    private val edtPassword = findViewById<EditText>(R.id.lg_edt_pass)
    private val btLogin = findViewById<Button>(R.id.lg_bt_login)
    private val txtRegister = findViewById<TextView>(R.id.lg_txt_register)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        btLogin.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}