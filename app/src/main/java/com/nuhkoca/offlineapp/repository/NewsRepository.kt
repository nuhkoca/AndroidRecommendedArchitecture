package com.nuhkoca.offlineapp.repository

import com.nuhkoca.offlineapp.api.INewsAPI
import com.nuhkoca.offlineapp.data.local.dao.NewsDao
import com.nuhkoca.offlineapp.data.local.entity.News
import com.nuhkoca.offlineapp.data.remote.NewsResponse
import com.nuhkoca.offlineapp.util.RateLimiter
import java.util.concurrent.TimeUnit

import javax.inject.Inject
import androidx.lifecycle.LiveData
import io.reactivex.Single

class NewsRepository @Inject
internal constructor(private val newsDao: NewsDao, private val iNewsAPI: INewsAPI) {

    private val rateLimiter = RateLimiter<String>(10, TimeUnit.SECONDS)

    fun loadNews(): LiveData<Resource<List<News>>> {
        return object : NetworkBoundResource<List<News>, NewsResponse>() {
            override fun saveCallResult(item: NewsResponse) {
                newsDao.saveNews(item.articles!!)
            }

            override fun shouldFetch(data: List<News>?): Boolean {
                return data == null || data.isEmpty() || rateLimiter.shouldFetch(RATE_LIMITER_TYPE)
            }

            override fun loadFromDb(): LiveData<List<News>> {
                return newsDao.loadNews()
            }

            override fun createCall(): Single<NewsResponse> {
                return iNewsAPI.news
            }

            override fun onFetchFailed() {
                rateLimiter.reset(RATE_LIMITER_TYPE)
            }
        }.asLiveData
    }

    companion object {

        private const val RATE_LIMITER_TYPE = "data"
    }
}
