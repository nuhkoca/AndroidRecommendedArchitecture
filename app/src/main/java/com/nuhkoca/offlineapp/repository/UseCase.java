package com.nuhkoca.offlineapp.repository;

import androidx.annotation.Nullable;
import androidx.lifecycle.LiveData;
import io.reactivex.disposables.Disposable;

/**
 * The [UseCase] helper class that runs repository methods
 * @param <M> represents model
 * @param <P> represents params
 *
 * @author nuhkoca
 */
public abstract class UseCase<M, P> {

    private NewsRepository newsRepository;

    /**
     * A default constructor that inject required dependencies
     *
     * @param newsRepository represents an instance of {@link NewsRepository}
     */
    public UseCase(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    public abstract LiveData<M> buildUseCaseObservable(@Nullable P params);

    /**
     * Executes the target call
     *
     * @param params   represents params to be passed
     * @return {@link Disposable} result
     */
    public LiveData<M> execute(@Nullable P params) {
        return buildUseCaseObservable(params);
    }

    /**
     * Returns an instance of {@link NewsRepository}
     *
     * @return an instance of {@link NewsRepository}
     */
    protected NewsRepository getNewsRepository() {
        return newsRepository;
    }
}
