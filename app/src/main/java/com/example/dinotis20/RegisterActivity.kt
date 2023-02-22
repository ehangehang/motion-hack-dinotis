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


    // variables
    private var phoneNumber = "+62"

    // elements
    private val edtPhoneNumber = findViewById<EditText>(R.id.rg_edt_phonenum)
    private val edtName = findViewById<EditText>(R.id.rg_edt_name)
    private val edtPassword = findViewById<EditText>(R.id.rg_edt_pass)
    private val edtRePassword = findViewById<EditText>(R.id.rg_edt_repass)
    private val btRegister = findViewById<Button>(R.id.rg_bt_register)
    private val txtLogin = findViewById<TextView>(R.id.rg_txt_login)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // TODO: register phone number
        auth = Firebase.auth

        btRegister.setOnClickListener{
            if (edtPhoneNumber.text.isNotEmpty()) {
                phoneNumber += edtPhoneNumber.text.toString()
                Toast.makeText(this, "Registered dummy", Toast.LENGTH_SHORT).show()
                startActivity(Intent(this, LoginActivity::class.java))
            } else {
                Toast.makeText(this, "Please enter a valid phone number!", Toast.LENGTH_SHORT).show()
            }
        }

        val user = User(phoneNumber, edtName.text.toString())

    }

    private fun sendOTP(phoneNumber: String) {
//        callbacks = object: PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
//
//        }
//        val options = PhoneAuthOptions.newBuilder(auth)
//            .setPhoneNumber(phoneNumber)
//            .setTimeout(60L, TimeUnit.SECONDS)
//            .setActivity(this)
//            .setCallbacks()
    }


}