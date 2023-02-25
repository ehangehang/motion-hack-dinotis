package com.example.dinotis20

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.dinotis20.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ktx.database
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.Properties
import java.util.concurrent.TimeUnit

class RegisterActivity : AppCompatActivity() {
    // Firebase
    private lateinit var auth: FirebaseAuth
    private val db = Firebase.firestore

    // elements
    private lateinit var edtEmail: EditText
    private lateinit var edtName: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtRePassword:EditText
    private lateinit var btRegister: Button
    private lateinit var txtLogin: TextView

    private fun init() {
        auth = Firebase.auth

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
                                writeNewUser(auth.currentUser?.uid.toString(), edtEmail.text.toString(), edtName.text.toString())
//                                Toast.makeText(this, "Successfully registered!", Toast.LENGTH_SHORT)
//                                    .show()
                                finish()
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

    private fun writeNewUser(userId: String, email: String, name: String) {
        val user = User(email, name)

        db.collection("Users").document(userId)
            .set(user)
            .addOnSuccessListener {
                Log.d("", "User data registered successfully!")
            }
            .addOnFailureListener { e ->
                Log.w("", "ERROR uploading user data: "+e)
            }
    }
}