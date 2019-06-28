package com.apps.myapplication.mvvm.mainhome

import android.app.Activity
import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.content.Intent
import android.os.CountDownTimer
import android.support.annotation.StringRes
import android.util.Log
import android.widget.Toast
import com.apps.myapplication.data.source.remote.ApiClient
import com.apps.myapplication.data.source.remote.ApiInterfaces
import com.apps.myapplication.data.source.remote.response.Article
import com.apps.myapplication.data.source.remote.response.NewsResponse
import com.apps.myapplication.utils.ConstantUtils
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import android.databinding.adapters.TextViewBindingAdapter.setText
import com.apps.myapplication.mvvm.maindetail.DetailActivity


class HomeViewModel(context: Application, activity: Activity) : AndroidViewModel(context)  {

    var newList = MutableLiveData<List<Article>>()
    val sliderList = ArrayList<Article>()
    var showProgress = MutableLiveData<Boolean>()
    var active_slide = MutableLiveData<Int>()
    var active_slide_img = MutableLiveData<String>()
    var active_slide_title = MutableLiveData<String>()
    var active_slide_desc = MutableLiveData<String>()
    var active_slide_index = MutableLiveData<Int>()
    var mcontext = context;
    var mactivity = activity;
    var count : Int = 1

    companion object {
        fun openDetailNews() : Article? = null
    }

    fun start(kategori : String) {
        getNews(kategori)
        start_slide()
    }

    fun start_slide(){
        var h = object : CountDownTimer(100000000, 4000) {
            override fun onTick(millisUntilFinished: Long) {
                if(sliderList.size > 0){
                    active_slide_index.postValue(count-1)
                    active_slide_title.postValue(sliderList[count-1].title)
                    active_slide_img.postValue(sliderList[count-1].urlToImage)
                    active_slide_desc.postValue(sliderList[count-1].author+" - "+sliderList[count-1].publishedAt)
                }
                ConstantUtils.check_timer = true
                active_slide.postValue(count)
                count = count + 1;
                if(count > 3){
                    count = 1
                }
            }

            override fun onFinish() {
                ConstantUtils.check_timer = false
            }
        }
        h.start()
    }
    fun getNews(kategori : String) {
        showProgress.value = true
        var apiInterface: ApiInterfaces? = ApiClient.getClient().create(ApiInterfaces::class.java)
        var call = apiInterface?.doGetIndoNews("id", ConstantUtils.API_KEY())
        if(kategori.equals("home")){
            call = apiInterface?.doGetIndoNews("id", ConstantUtils.API_KEY())
        }else{
            call = apiInterface?.doGetIndoNewsWithCategory("id", ConstantUtils.API_KEY(), kategori)
        }
        call?.enqueue(object : Callback<NewsResponse> {

            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if(response.body()?.totalResults.toString().equals("0")){
                    Toast.makeText(mcontext,"Data Kosong",Toast.LENGTH_LONG).show();
                }else{
                    for (i in 0..2) {
                        sliderList.add(response.body()?.articles!![i])
                    }
                    active_slide_index.postValue(0)
                    active_slide_title.postValue(response.body()?.articles!![0].title)
                    active_slide_img.postValue(response.body()?.articles!![0].urlToImage)
                    active_slide_desc.postValue(response.body()?.articles!![0].author+" - "+response.body()?.articles!![0].publishedAt)
                    newList.postValue(response.body()?.articles);
                    showProgress.value = false
                }
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Toast.makeText(mcontext,t.message.toString(),Toast.LENGTH_LONG).show();
                call.cancel()
            }
        })
    }

    fun onClickSlider(index: Int) {
        Log.d("cekclickslider","berhasil")
        if (sliderList[index].author == null){
            ConstantUtils.author = ""
        }else{
            ConstantUtils.author = sliderList[index].author
        }
        if (sliderList[index].content == null){
            ConstantUtils.content = ""
        }else{
            ConstantUtils.content = sliderList[index].content
        }
        ConstantUtils.description = sliderList[index].description
        ConstantUtils.publishedAt = sliderList[index].publishedAt
        ConstantUtils.source = sliderList[index].source.name
        ConstantUtils.title = sliderList[index].title
        ConstantUtils.url = sliderList[index].url
        ConstantUtils.urlToImage = sliderList[index].urlToImage
        val i = Intent(mactivity, DetailActivity::class.java)
        mactivity.startActivity(i)
    }


}