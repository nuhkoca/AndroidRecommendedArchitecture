package com.nuhkoca.offlineapp.repository;

import com.nuhkoca.offlineapp.api.INewsAPI;
import com.nuhkoca.offlineapp.data.local.dao.NewsDao;
import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.data.remote.NewsResponse;
import com.nuhkoca.offlineapp.util.RateLimiter;

import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import io.reactivex.Single;

public class NewsRepository {

    private final NewsDao newsDao;
    private final INewsAPI iNewsAPI;

    @Inject
    NewsRepository(NewsDao newsDao, INewsAPI iNewsAPI) {
        this.newsDao = newsDao;
        this.iNewsAPI = iNewsAPI;
    }

    private RateLimiter<String> rateLimiter = new RateLimiter<>(10, TimeUnit.SECONDS);

    public LiveData<Resource<List<News>>> loadNews() {
        return new NetworkBoundResource<List<News>, NewsResponse>() {
            @Override
            protected void saveCallResult(@NotNull @NonNull NewsResponse item) {
                newsDao.saveNews(item.getArticles());
            }

            @Override
            protected boolean shouldFetch(@Nullable List<News> data) {
                return data == null || data.isEmpty() || rateLimiter.shouldFetch("data");
            }

            @NotNull
            @NonNull
            @Override
            protected LiveData<List<News>> loadFromDb() {
                return newsDao.loadNews();
            }

            @NotNull
            @NonNull
            @Override
            protected Single<NewsResponse> createCall() {
                return iNewsAPI.getNews();
            }

            @Override
            protected void onFetchFailed() {
                rateLimiter.reset("data");
            }
        }.getAsLiveData();
    }
}
