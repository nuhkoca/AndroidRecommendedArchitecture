package com.nuhkoca.offlineapp.ui.news;

import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.repository.NewsRepository;
import com.nuhkoca.offlineapp.repository.Resource;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import javax.inject.Inject;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {
    private final LiveData<Resource<List<News>>> news;

    @Inject
    NewsViewModel(@NotNull NewsRepository newsRepository) {
        news = newsRepository.loadNews();
    }

    public LiveData<Resource<List<News>>> getNews() {
        return news;
    }
}
