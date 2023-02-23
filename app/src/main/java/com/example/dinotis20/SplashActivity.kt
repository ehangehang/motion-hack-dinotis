package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class SplashActivity : AppCompatActivity() {

    private var onBoardDone = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
        PreferenceManager.getDefaultSharedPreferences(this).apply {
            onBoardDone = getBoolean("onBoardDone", false)
        }

        Handler(Looper.getMainLooper()).postDelayed({
            if (onBoardDone) {
                startActivity(Intent(this, MainActivity::class.java))
            } else {
                startActivity(Intent(this, OnboardingActivity::class.java))
            }
            finish()
        }, 3000)
    }
}