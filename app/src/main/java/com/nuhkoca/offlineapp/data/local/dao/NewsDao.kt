package com.nuhkoca.offlineapp.data.local.dao

import com.nuhkoca.offlineapp.data.local.entity.News

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface NewsDao {

    @Query("SELECT * FROM news")
    fun loadNews(): LiveData<List<News>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun saveNews(news: List<News>)

    @Query("SELECT * FROM news WHERE id=:id")
    fun getNews(id: Int): LiveData<News>
}
