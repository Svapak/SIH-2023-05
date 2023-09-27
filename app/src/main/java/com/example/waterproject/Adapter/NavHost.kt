package com.example.waterproject.Adapter

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.waterproject.HomeFragment
import com.example.waterproject.IssueFragment
import com.example.waterproject.ReachOut
import com.example.waterproject.settings

internal class NavHost(var context: Context, fm: FragmentManager, var totalTabs: Int):
    FragmentPagerAdapter(fm) {


    override fun getItem(position: Int): Fragment {
        return when(position)
        {
            0 -> {HomeFragment()}
            1 -> {IssueFragment()}
            2 -> {ReachOut()}
            3 -> {settings()}
            else -> getItem(position)
        }
    }
    override fun getCount(): Int {
        return totalTabs

    }
}