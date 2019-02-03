package com.nuhkoca.offlineapp.data.remote;

import com.google.gson.annotations.SerializedName;
import com.nuhkoca.offlineapp.BR;
import com.nuhkoca.offlineapp.data.local.entity.News;

import java.util.List;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;

public class NewsResponse extends BaseObservable {

    @SerializedName("articles")
    private List<News> articles;

    @Bindable
    public List<News> getArticles() {
        return articles;
    }

    public void setArticles(List<News> articles) {
        this.articles = articles;
        notifyPropertyChanged(BR.articles);
    }
}
