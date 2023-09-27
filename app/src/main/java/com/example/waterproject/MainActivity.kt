package com.example.waterproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.viewpager.widget.ViewPager
import com.example.waterproject.Adapter.NavHost
import com.google.android.material.tabs.TabLayout
import com.ismaeldivita.chipnavigation.ChipNavigationBar

private lateinit var navBar:ChipNavigationBar
private lateinit var viewPager : ViewPager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navBar = findViewById(R.id.navBar)
        navBar.setMenuResource(R.menu.navmenu)

        //tabLayout : TabLayout= tabLayout
        //viewPager: ViewPager = viewPager
        viewPager = findViewById(R.id.viewPager)


        val adapter = NavHost(this, supportFragmentManager, 4)
        viewPager.adapter = adapter

//        val homeFragment = HomeFragment()
//        val issues = IssueFragment()
//        val solutins = ReachOut()
//        val settings = settings()

        navBar.setOnItemSelectedListener { index ->
            viewPager.currentItem=index
            }
           // else -> getItem(position)

        }

    }

