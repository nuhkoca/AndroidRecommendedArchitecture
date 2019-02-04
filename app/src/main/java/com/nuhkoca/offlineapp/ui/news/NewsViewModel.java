package com.nuhkoca.offlineapp.ui.news;

import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.repository.Resource;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

public class NewsViewModel extends ViewModel {
    private final LiveData<Resource<List<News>>> news;

    @Inject
    NewsViewModel(@NonNull NewsUseCase newsUseCase) {
        news = newsUseCase.execute(null);
    }

    public LiveData<Resource<List<News>>> getNews() {
        return news;
    }
}
