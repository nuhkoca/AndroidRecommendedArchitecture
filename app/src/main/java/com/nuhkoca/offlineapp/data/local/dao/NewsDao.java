package com.nuhkoca.offlineapp.data.local.dao;

import com.nuhkoca.offlineapp.data.local.entity.News;

import java.util.List;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

@Dao
public interface NewsDao {

    @Query("SELECT * FROM news")
    LiveData<List<News>> loadNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveNews(List<News> news);

    @Query("SELECT * FROM news WHERE id=:id")
    LiveData<News> getNews(int id);
}
