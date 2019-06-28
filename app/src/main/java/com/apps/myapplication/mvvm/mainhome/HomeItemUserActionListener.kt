package com.apps.myapplication.mvvm.mainhome

import com.apps.myapplication.data.source.remote.response.Article

interface HomeItemUserActionListener {
    fun onNewsClicked(news: Article)
}