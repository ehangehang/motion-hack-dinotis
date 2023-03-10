package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
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
    private lateinit var btEye : ImageView
    private var passVisible = false

    private fun init() {
        auth = Firebase.auth

        edtEmail = findViewById(R.id.lg_edt_email)
        edtPassword = findViewById(R.id.lg_edt_pass)
        btLogin = findViewById(R.id.lg_bt_login)
        txtRegister = findViewById(R.id.lg_txt_register)
        btEye = findViewById(R.id.lg_bt_eye)
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

        btEye.setOnClickListener {
            if (!passVisible) {
                edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btEye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye))
                passVisible = true
            } else {
                edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                btEye.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash))
                passVisible = false
            }
        }
    }
}