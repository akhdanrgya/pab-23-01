package com.example.pab_23_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class TigaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setupScreen(R.layout.activity_tiga, R.id.nav_info)
    }
}
