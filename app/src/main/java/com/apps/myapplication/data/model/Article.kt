package com.apps.myapplication.data.model

import com.apps.myapplication.data.source.remote.response.Source
import java.io.Serializable

data class Article(
    var author: String? = null,
    var content: String? = null,
    var description: String? = null,
    var publishedAt: String? = null,
    var source: Source? = null,
    var title: String? = null,
    var url: String? = null,
    var urlToImage: String? = null
): Serializable