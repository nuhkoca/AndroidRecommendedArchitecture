package com.nuhkoca.offlineapp.di.module;

import android.content.Context;

import com.nuhkoca.offlineapp.data.local.dao.NewsDao;
import com.nuhkoca.offlineapp.db.NewsDB;
import com.nuhkoca.offlineapp.helper.Constants;

import javax.inject.Singleton;

import androidx.annotation.NonNull;
import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;
import dagger.Module;
import dagger.Provides;

@Module
public class RoomModule {

    /**
     * Returns an instance of Migration
     *
     * @return an instance of {@link Migration}
     */
    @Singleton
    @Provides
    Migration provideMigration() {
        return new Migration(Constants.DB_MIGRATION_START_VERSION, Constants.DB_MIGRATION_TARGET_VERSION) {
            @Override
            public void migrate(@NonNull SupportSQLiteDatabase database) {
                // Do nothing
            }
        };
    }

    /**
     * Returns an instance of NewsDB
     *
     * @param context   represents an instance of {@link Context}
     * @param migration represents a custom {@link Migration}
     * @return an instance of {@link NewsDB}
     */
    @Singleton
    @Provides
    NewsDB provideNewsDB(@NonNull Context context, @NonNull Migration migration) {
        return Room.databaseBuilder(context, NewsDB.class, Constants.NEWS_DB_NAME)
                .addMigrations(migration)
                .build();
    }

    /**
     * Returns an instance of NewsDao
     *
     * @param newsDB an instance of {@link NewsDB}
     * @return an instance of {@link NewsDao}
     */
    @Singleton
    @Provides
    NewsDao provideNewsDao(@NonNull NewsDB newsDB) {
        return newsDB.newsDao();
    }
}
