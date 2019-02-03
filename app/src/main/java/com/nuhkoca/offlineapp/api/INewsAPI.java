package com.nuhkoca.offlineapp.api;

import com.nuhkoca.offlineapp.data.remote.NewsResponse;

import io.reactivex.Single;
import retrofit2.http.GET;

/**
 * The main services that handles all endpoint processes
 *
 * @author nuhkoca
 */
public interface INewsAPI {

    @GET("everything?q=android&sortBy=popularity&sources=hacker-news,techcrunch&page=1")
    Single<NewsResponse> getNews();
}
