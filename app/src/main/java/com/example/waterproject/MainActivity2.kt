package com.example.waterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity2 : AppCompatActivity() {
    private lateinit var navBar: ChipNavigationBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        navBar=findViewById(R.id.navBar)
        navBar.setMenuResource(R.menu.navmenu)
    }
}