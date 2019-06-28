package com.apps.myapplication.base


import android.content.Context
import android.os.Bundle
import android.support.annotation.IdRes
import android.support.annotation.Nullable
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity



/**
 * Created by irfanirawansukirman on 26/01/18.
 */

open class BaseActivity : AppCompatActivity() {

    lateinit var mActiviy: AppCompatActivity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        mActiviy = this
    }
    //Todo attach base context calligraphy font in here

    override fun attachBaseContext(newBase: Context?) {
        super.attachBaseContext(newBase);
    }


    public fun addFragment(@IdRes containerViewId: Int,
                              fragment: Fragment,
                              fragmentTag: String) {
        supportFragmentManager
            .beginTransaction()
            .add(containerViewId, fragment, fragmentTag)
            .disallowAddToBackStack()
            .commit()
    }

    public fun replaceFragment(@IdRes containerViewId: Int,
                                  fragment: Fragment,
                                  fragmentTag: String,
                                  @Nullable backStackStateName: String) {
        supportFragmentManager
            .beginTransaction()
            .replace(containerViewId, fragment, fragmentTag)
            .addToBackStack(backStackStateName)
            .commit()
    }
}