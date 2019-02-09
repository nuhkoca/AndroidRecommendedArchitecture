package com.nuhkoca.offlineapp.repository

import androidx.lifecycle.LiveData
import io.reactivex.disposables.Disposable

/**
 * The [UseCaseLiveData] helper class that runs repository methods
 * @param <M> represents model
 * @param <P> represents params
 *
 * @author nuhkoca
 */
abstract class UseCaseLiveData<M, P>(newsRepository: NewsRepository) {

    internal val repository: NewsRepository = newsRepository

    abstract fun buildUseCaseObservable(params: P?): LiveData<M>

    /**
     * Executes the target call
     *
     * @param params   represents params to be passed
     * @return [Disposable] result
     */
    fun execute(params: P?): LiveData<M> {
        return buildUseCaseObservable(params)
    }

    fun getNewsRepository(): NewsRepository {
        return repository
    }

    class None
}
