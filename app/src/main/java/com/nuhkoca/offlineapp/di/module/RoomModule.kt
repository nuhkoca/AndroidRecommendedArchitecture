package com.nuhkoca.offlineapp.di.module

import android.content.Context

import com.nuhkoca.offlineapp.data.local.dao.NewsDao
import com.nuhkoca.offlineapp.db.NewsDB
import com.nuhkoca.offlineapp.helper.Constants

import javax.inject.Singleton
import androidx.room.Room
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import dagger.Module
import dagger.Provides

@Module
class RoomModule {

    /**
     * Returns an instance of Migration
     *
     * @return an instance of [Migration]
     */
    @Singleton
    @Provides
    internal fun provideMigration(): Migration {
        return object : Migration(Constants.DB_MIGRATION_START_VERSION, Constants.DB_MIGRATION_TARGET_VERSION) {
            override fun migrate(database: SupportSQLiteDatabase) {
                // Do nothing
            }
        }
    }

    /**
     * Returns an instance of NewsDB
     *
     * @param context   represents an instance of [Context]
     * @param migration represents a custom [Migration]
     * @return an instance of [NewsDB]
     */
    @Singleton
    @Provides
    internal fun provideNewsDB(context: Context, migration: Migration): NewsDB {
        return Room.databaseBuilder(context, NewsDB::class.java, Constants.NEWS_DB_NAME)
                .addMigrations(migration)
                .build()
    }

    /**
     * Returns an instance of NewsDao
     *
     * @param newsDB an instance of [NewsDB]
     * @return an instance of [NewsDao]
     */
    @Singleton
    @Provides
    internal fun provideNewsDao(newsDB: NewsDB): NewsDao {
        return newsDB.newsDao()
    }
}
