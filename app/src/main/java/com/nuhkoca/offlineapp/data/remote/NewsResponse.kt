package com.nuhkoca.offlineapp.data.remote

import com.google.gson.annotations.SerializedName
import com.nuhkoca.offlineapp.data.local.entity.News

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import com.nuhkoca.offlineapp.BR

class NewsResponse : BaseObservable() {

    @SerializedName("articles")
    @get:Bindable
    var articles: List<News>? = null
        set(articles) {
            field = articles
            notifyPropertyChanged(BR.articles)
        }
}
