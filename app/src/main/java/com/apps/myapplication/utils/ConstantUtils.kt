package com.apps.myapplication.utils

import android.arch.lifecycle.MutableLiveData
import com.apps.myapplication.data.source.remote.response.Article

class ConstantUtils {
    companion object {
        fun BASE_URL() : String = "https://newsapi.org/"
        fun API_KEY() : String = "e001b31f8aab4f87bab8670602fa6b8f"
        var check_timer : Boolean = false
        var author = ""
        var content = ""
        var description = ""
        var publishedAt = ""
        var source = ""
        var title = ""
        var url = ""
        var urlToImage = ""

    }
}