package com.nuhkoca.offlineapp.ui.news

import com.nuhkoca.offlineapp.data.local.entity.News
import com.nuhkoca.offlineapp.repository.NewsRepository
import com.nuhkoca.offlineapp.repository.Resource
import com.nuhkoca.offlineapp.repository.UseCaseLiveData

import javax.inject.Inject
import androidx.lifecycle.LiveData
import io.reactivex.Single

/**
 * A [UseCaseLiveData] pattern for playable content
 *
 * @author nuhkoca
 */
class NewsUseCase @Inject
internal constructor(newsRepository: NewsRepository) : UseCaseLiveData<Resource<List<News>>, UseCaseLiveData.None>(newsRepository) {

    /**
     * Build use case with the power of RxJava
     *
     * @param params represents params to be passed
     * @return a [Single] response
     */
    override fun buildUseCaseObservable(params: None?): LiveData<Resource<List<News>>> {
        return getNewsRepository().loadNews()
    }
}
