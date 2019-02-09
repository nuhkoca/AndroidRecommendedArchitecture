package com.nuhkoca.offlineapp.api

import com.nuhkoca.offlineapp.BuildConfig
import com.nuhkoca.offlineapp.helper.Constants
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

/**
 * A class that includes sensitive data to each network call
 *
 * @author nuhkoca
 */
@Singleton
class AuthInterceptor
/**
 * A default constructor that gets dependencies
 */
@Inject
constructor() : Interceptor {

    /**
     * Adds specific headers to requests
     *
     * @param chain represents [Chain]
     * @return response with headers and others
     * @throws IOException throws
     */
    @Throws(IOException::class)
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        val originalUrl = original.url()
        val url = originalUrl.newBuilder()
                .addQueryParameter(Constants.API_KEY, BuildConfig.API_KEY)
                .build()
        val requestBuilder = original.newBuilder().url(url)
        val newRequest = requestBuilder.build()

        return chain.proceed(newRequest)
    }
}
