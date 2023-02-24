package com.example.dinotis20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    // Firebase
    private lateinit var auth: FirebaseAuth

    // variables
    private var phoneNumber = "+62"

    // elements
    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btLogin: Button
    private lateinit var txtRegister: TextView

    private fun init() {
        auth = Firebase.auth

        edtEmail = findViewById(R.id.lg_edt_email)
        edtPassword = findViewById(R.id.lg_edt_pass)
        btLogin = findViewById(R.id.lg_bt_login)
        txtRegister = findViewById(R.id.lg_txt_register)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()

        btLogin.setOnClickListener {
            if (edtEmail.text.isNotEmpty() && edtPassword.text.isNotEmpty()) {
                btLogin.isEnabled = false
                auth.signInWithEmailAndPassword(edtEmail.text.toString(), edtPassword.text.toString())
                    .addOnCompleteListener { task ->
                        if (task.isSuccessful) {
                            startActivity(Intent(this, MainActivity::class.java))
                            finish()
                        } else {
                            btLogin.isEnabled = true
                            Toast.makeText(this, "Login Failed!", Toast.LENGTH_SHORT).show()
                        }
                    }
            } else {
                Toast.makeText(this, "Fill all information!", Toast.LENGTH_SHORT).show()
            }
        }

        txtRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
}