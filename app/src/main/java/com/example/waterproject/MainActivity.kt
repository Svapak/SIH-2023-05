package com.example.waterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ismaeldivita.chipnavigation.ChipNavigationBar

private lateinit var navBar:ChipNavigationBar
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navBar=findViewById(R.id.navBar)
        navBar.setMenuResource(R.menu.navmenu)

    }
}