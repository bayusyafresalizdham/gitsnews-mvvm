package com.apps.myapplication.mvvm.maindetail


import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import com.apps.myapplication.data.source.remote.ApiClient
import com.apps.myapplication.data.source.remote.ApiInterfaces
import com.apps.myapplication.data.source.remote.response.Article
import com.apps.myapplication.data.source.remote.response.NewsResponse
import com.apps.myapplication.data.source.remote.response.Source
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.support.design.widget.Snackbar
import android.support.v4.os.HandlerCompat.postDelayed
import android.R.attr.password
import android.app.Activity


class DetailViewModel(context: Application,activity: Activity) : AndroidViewModel(context)  {

    var author = MutableLiveData<String>()
    var content = MutableLiveData<String>()
    var description= MutableLiveData<String>()
    var publishedAt= MutableLiveData<String>()
    var source= MutableLiveData<String>()
    var title= MutableLiveData<String>()
    var url= MutableLiveData<String>()
    var urlToImage= MutableLiveData<String>()
    var mcontext = context;
    var mactivity = activity;


    fun start() {
        getDetail()
    }

    fun getDetail() {
        urlToImage.postValue(ConstantUtils.urlToImage)
        title.postValue(ConstantUtils.title)
        publishedAt.postValue(ConstantUtils.publishedAt)
        author.postValue(ConstantUtils.publishedAt)
        content.postValue(ConstantUtils.content)
    }

    fun onClickFinish() {
        Log.d("coba","cok")
        mactivity.finish()
    }

}