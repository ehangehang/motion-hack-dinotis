package com.example.dinotis20

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.preference.PreferenceManager
import org.w3c.dom.Text

class OnboardingActivity : AppCompatActivity() {

    private lateinit var onboardingImage: ImageView
    private lateinit var onboardingButton: Button
    private lateinit var onboardingTitle: TextView
    private lateinit var onboardingSubtitle: TextView
    private var slideNumber = 1

    fun init() {
        onboardingImage = findViewById(R.id.onboarding_image)
        onboardingButton = findViewById(R.id.onboarding_button)
        onboardingTitle = findViewById(R.id.onboarding_title)
        onboardingSubtitle = findViewById(R.id.onboarding_subtitle)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        init()

        onboardingButton = findViewById(R.id.onboarding_button)
        onboardingButton.setOnClickListener {
            if (slideNumber == 1) {
                slideNumber++
                onboardingImage.setImageDrawable(resources.getDrawable(R.drawable.onboarding_second))
                onboardingTitle.text = resources.getText(R.string.onboarding_second_title)
                onboardingSubtitle.text = resources.getText(R.string.onboarding_second_subtitle)
                onboardingButton.text = "Done"
            } else {
                PreferenceManager.getDefaultSharedPreferences(this).edit().apply {
                    putBoolean("onBoardDone", true)
                    apply()
                }
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        }
    }

    companion object {
        const val COMPLETED_ONBOARD_PREF_NAME = "onBoardDone"
    }
}