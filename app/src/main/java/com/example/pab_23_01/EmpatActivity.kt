package com.example.pab_23_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class EmpatActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScreen(R.layout.activity_empat, R.id.nav_about)
    }
}
