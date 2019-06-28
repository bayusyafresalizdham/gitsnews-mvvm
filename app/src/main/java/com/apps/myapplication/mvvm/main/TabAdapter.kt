package com.apps.myapplication.mvvm.main

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.apps.myapplication.mvvm.mainabout.AboutFragment
import com.apps.myapplication.mvvm.mainhome.HomeFragment
import com.apps.myapplication.mvvm.mainprofil.ProfilFragment

class TabAdapter(fm: FragmentManager): FragmentPagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> {
                HomeFragment.newInstance("home")
            }
            1 -> {
                HomeFragment.newInstance("business")
            }
            2 -> {
                HomeFragment.newInstance("entertainment")
            }
            3 -> {
                HomeFragment.newInstance("health")
            }
            4 -> {
                AboutFragment()
            }
            else -> {
                return ProfilFragment()
            }
        }
    }

    override fun getCount(): Int {
        return 6
    }

    override fun getPageTitle(position: Int): CharSequence {
        return when (position) {
            0 -> "Home"
            1 -> "Business"
            2 -> "Entertainment"
            3 -> "Health"
            4 -> "About"
            else -> {
                return "Profile"
            }
        }
    }
}