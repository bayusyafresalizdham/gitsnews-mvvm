package com.apps.myapplication.mvvm.main

import android.content.DialogInterface
import android.databinding.DataBindingUtil
import android.os.Bundle
import com.apps.myapplication.R
import com.apps.myapplication.base.BaseActivity
import android.support.v4.view.ViewPager
import android.support.design.widget.TabLayout
import android.databinding.BindingAdapter
import android.support.v7.app.AlertDialog
import android.view.View
import android.widget.EditText
import kotlinx.android.synthetic.main.main_activity.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        val fragmentAdapter = TabAdapter(supportFragmentManager)
        viewpager_main.adapter = fragmentAdapter
        tabs_main.setupWithViewPager(viewpager_main)


    }



}