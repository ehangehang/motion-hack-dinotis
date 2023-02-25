package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.text.method.HideReturnsTransformationMethod
import android.text.method.PasswordTransformationMethod
import android.util.Log
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.example.dinotis20.model.User
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

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
    private lateinit var btEyePass : ImageView
    private lateinit var btEyeRepass : ImageView
    private var passVisible = false
    private var repassVisible = false

    private fun init() {
        auth = Firebase.auth

        edtEmail = findViewById(R.id.rg_edt_email)
        edtName = findViewById(R.id.rg_edt_name)
        edtPassword = findViewById(R.id.rg_edt_pass)
        edtRePassword = findViewById(R.id.rg_edt_repass)
        btRegister = findViewById(R.id.rg_bt_register)
        txtLogin = findViewById(R.id.rg_txt_login)
        btEyePass = findViewById(R.id.rg_bt_pass_eye)
        btEyeRepass = findViewById(R.id.rg_bt_repass_eye)
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


        btEyePass.setOnClickListener {
            if (!passVisible) {
                edtPassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btEyePass.setImageDrawable(resources.getDrawable(R.drawable.ic_eye))
                passVisible = true
            } else {
                edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
                btEyePass.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash))
                passVisible = false
            }
        }

        btEyeRepass.setOnClickListener {
            if (!repassVisible) {
                edtRePassword.transformationMethod = HideReturnsTransformationMethod.getInstance()
                btEyeRepass.setImageDrawable(resources.getDrawable(R.drawable.ic_eye))
                repassVisible = true
            } else {
                edtRePassword.transformationMethod = PasswordTransformationMethod.getInstance()
                btEyeRepass.setImageDrawable(resources.getDrawable(R.drawable.ic_eye_slash))
                repassVisible = false
            }
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