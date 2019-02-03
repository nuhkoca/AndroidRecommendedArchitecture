package com.nuhkoca.offlineapp.db;

import com.nuhkoca.offlineapp.data.local.dao.NewsDao;
import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.helper.DateTypeConverter;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

@Database(entities = {News.class}, version = 1, exportSchema = false)
@TypeConverters(DateTypeConverter.class)
public abstract class NewsDB extends RoomDatabase {

    public abstract NewsDao newsDao();
}
