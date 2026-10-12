package com.example.pab_23_01

import android.content.Intent
import android.view.View
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.android.material.bottomnavigation.BottomNavigationView

fun AppCompatActivity.setupScreen(layoutId: Int, selectedItem: Int) {
    setContentView(R.layout.activity_navigation)
    val container = findViewById<FrameLayout>(R.id.screen_content)
    layoutInflater.inflate(layoutId, container, true)

    val root = findViewById<View>(R.id.navigation_root)
    ViewCompat.setOnApplyWindowInsetsListener(root) { view, insets ->
        val bars = insets.getInsets(
            WindowInsetsCompat.Type.systemBars() or WindowInsetsCompat.Type.ime()
        )
        view.setPadding(bars.left, bars.top, bars.right, bars.bottom)
        WindowInsetsCompat.CONSUMED
    }
    ViewCompat.requestApplyInsets(root)

    val navigation = findViewById<BottomNavigationView>(R.id.bottom_navigation)
    navigation.selectedItemId = selectedItem
    navigation.setOnItemSelectedListener { item ->
        val target = when (item.itemId) {
            R.id.nav_form -> MainActivity::class.java
            R.id.nav_info -> TigaActivity::class.java
            R.id.nav_about -> EmpatActivity::class.java
            else -> return@setOnItemSelectedListener false
        }
        if (javaClass != target) {
            startActivity(Intent(this, target).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            })
            if (this !is MainActivity) finish()
            return@setOnItemSelectedListener false
        }
        true
    }
    navigation.setOnItemReselectedListener { item ->
        if (item.itemId == R.id.nav_form && this !is MainActivity) {
            startActivity(Intent(this, MainActivity::class.java).apply {
                addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP or Intent.FLAG_ACTIVITY_SINGLE_TOP)
            })
            finish()
        }
    }
}
