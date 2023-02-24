package com.example.dinotis20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.dinotis20.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import java.util.concurrent.TimeUnit

class RegisterActivity : AppCompatActivity() {
    // Firebase
    private lateinit var auth: FirebaseAuth

    // elements
    private lateinit var edtEmail: EditText
    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtRePassword:EditText
    private lateinit var btRegister: Button
    private lateinit var txtLogin: TextView

    private fun init() {
        edtEmail = findViewById(R.id.rg_edt_email)
        edtName = findViewById(R.id.rg_edt_name)
        edtPassword = findViewById(R.id.rg_edt_pass)
        edtRePassword = findViewById(R.id.rg_edt_repass)
        btRegister = findViewById(R.id.rg_bt_register)
        txtLogin = findViewById(R.id.rg_txt_login)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        init()

        auth = Firebase.auth

        btRegister.setOnClickListener{
            if (edtEmail.text.isNotEmpty()) {
                if (edtPassword.text.toString() == edtRePassword.text.toString()) {
                    auth.createUserWithEmailAndPassword(
                        edtEmail.text.toString(),
                        edtPassword.text.toString()
                    )
                        .addOnCompleteListener(this) { task ->
                            if (task.isSuccessful) {
                                val user = auth.currentUser
                                Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT)
                                    .show()
                                startActivity(Intent(this, LoginActivity::class.java))
                            } else {
                                Toast.makeText(
                                    this,
                                    "Registration failed, please check your credentials",
                                    Toast.LENGTH_SHORT
                                )
                                    .show()
                            }
                        }
                } else {
                    Toast.makeText(this, "Password is different!", Toast.LENGTH_SHORT).show()
                }
            } else {
                Toast.makeText(this, "Please enter a valid credentials!", Toast.LENGTH_SHORT).show()
            }
        }

        txtLogin.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }

//        val user = User(edtEmail.text.toString(), edtName.text.toString())

    }
}