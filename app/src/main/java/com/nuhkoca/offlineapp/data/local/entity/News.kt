package com.nuhkoca.offlineapp.data.local.entity

import com.google.gson.annotations.SerializedName
import com.nuhkoca.offlineapp.BR

import java.util.Date

import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.room.Entity
import androidx.room.Index
import androidx.room.PrimaryKey

@Entity(tableName = "news", indices = [Index(value = ["title"], unique = true)])
class News : BaseObservable() {

    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    @get:Bindable
    var id: Int = 0
        set(id) {
            field = id
            notifyPropertyChanged(BR.id)
        }

    @SerializedName("title")
    @get:Bindable
    var title: String? = null
        set(title) {
            field = title
            notifyPropertyChanged(BR.title)
        }

    @SerializedName("author")
    @get:Bindable
    var author: String? = null
        set(author) {
            field = author
            notifyPropertyChanged(BR.author)
        }

    @SerializedName("description")
    @get:Bindable
    var description: String? = null
        set(description) {
            field = description
            notifyPropertyChanged(BR.description)
        }

    @SerializedName("url")
    @get:Bindable
    var url: String? = null
        set(url) {
            field = url
            notifyPropertyChanged(BR.url)
        }

    @SerializedName("urlToImage")
    @get:Bindable
    var urlToImage: String? = null
        set(urlToImage) {
            field = urlToImage
            notifyPropertyChanged(BR.urlToImage)
        }

    @SerializedName("publishedAt")
    @get:Bindable
    var publishedAt: Date? = null
        set(publishedAt) {
            field = publishedAt
            notifyPropertyChanged(BR.publishedAt)
        }

    @SerializedName("content")
    @get:Bindable
    var content: String? = null
        set(content) {
            field = content
            notifyPropertyChanged(BR.content)
        }
}
