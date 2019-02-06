package com.nuhkoca.offlineapp.ui.news;

import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.repository.NewsRepository;
import com.nuhkoca.offlineapp.repository.Resource;
import com.nuhkoca.offlineapp.repository.UseCaseLiveData;

import java.util.List;

import javax.inject.Inject;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import io.reactivex.Single;

/**
 * A [UseCaseLiveData] pattern for playable content
 *
 * @author nuhkoca
 */
public class NewsUseCase extends UseCaseLiveData<Resource<List<News>>, String> {

    /**
     * A default constructor that inject required dependencies
     *
     * @param newsRepository represents an instance of {@link NewsRepository}
     */
    @Inject
    NewsUseCase(NewsRepository newsRepository) {
        super(newsRepository);
    }

    /**
     * Build use case with the power of RxJava
     *
     * @param params represents params to be passed
     * @return a {@link Single} response
     */
    @Override
    public LiveData<Resource<List<News>>> buildUseCaseObservable(@Nullable String params) {
        return getNewsRepository().loadNews();
    }
}
