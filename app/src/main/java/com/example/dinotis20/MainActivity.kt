package com.example.dinotis20

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.FragmentContainerView
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragment = findViewById<FragmentContainerView>(R.id.main_fragment_container)
        val bottomNav = findViewById<BottomNavigationView>(R.id.main_bottom_nav)

        bottomNav.setupWithNavController(fragment.findNavController())
    }
}