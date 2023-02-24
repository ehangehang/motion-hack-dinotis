package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class SplashActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    private var onBoardDone = false

    private fun init() {
        auth = Firebase.auth
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()

        val currentUser = auth.currentUser

        PreferenceManager.getDefaultSharedPreferences(this).apply {
            onBoardDone = getBoolean("onBoardDone", false)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardDone) {
                if (currentUser != null) {
                    startActivity(Intent(this, MainActivity::class.java))
                } else {
                    startActivity(Intent(this, LoginActivity::class.java))
                }
            } else {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 3000)
    }
}