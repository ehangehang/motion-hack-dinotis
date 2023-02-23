package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager

class OnboardingActivity : AppCompatActivity() {

    private lateinit var nextButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        nextButton = findViewById(R.id.ob_button_next)
        nextButton.setOnClickListener {
            PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
                putBoolean("onBoardDone", true)
                apply()
            }
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }
    }

    companion object {
        const val COMPLETED_ONBOARD_PREF_NAME = "onBoardDone"
    }
}