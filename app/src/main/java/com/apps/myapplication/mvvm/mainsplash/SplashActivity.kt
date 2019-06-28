package com.apps.myapplication.mvvm.mainsplash

import android.os.Bundle
import android.os.PersistableBundle
import com.apps.myapplication.R
import com.apps.myapplication.base.BaseActivity
import android.content.Intent
import android.support.v4.os.HandlerCompat.postDelayed
import android.os.Handler
import com.apps.myapplication.mvvm.main.MainActivity
import java.lang.Exception


class SplashActivity : BaseActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)
        Handler().postDelayed(Runnable {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }, 4000)
    }
}