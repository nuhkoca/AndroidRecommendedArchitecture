package com.nuhkoca.offlineapp.di.module

import com.google.gson.FieldNamingPolicy
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.nuhkoca.offlineapp.BuildConfig
import com.nuhkoca.offlineapp.api.AuthInterceptor
import com.nuhkoca.offlineapp.api.INewsAPI
import com.nuhkoca.offlineapp.helper.Constants

import java.util.concurrent.TimeUnit

import javax.inject.Singleton
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

/**
 * A [Module] that handles network injections
 *
 * @author nuhkoca
 */
@Module
class NetModule {

    /**
     * Returns an instance of Gson
     *
     * @return an instance of [Gson]
     */
    @Provides
    @Singleton
    internal fun provideGson(): Gson {
        return GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.IDENTITY)
                .serializeNulls()
                .setLenient()
                .setDateFormat("dd-MM-yyyy")
                .create()
    }

    /**
     * Returns an instance of [HttpLoggingInterceptor]
     *
     * @return an instance of [HttpLoggingInterceptor]
     */
    @Provides
    @Singleton
    internal fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
    }

    /**
     * Returns an instance of [OkHttpClient]
     *
     * @param httpLoggingInterceptor represents an instance of [HttpLoggingInterceptor]
     * @param authInterceptor        represents an instance of [AuthInterceptor]
     * @return an instance of [OkHttpClient]
     */
    @Provides
    @Singleton
    internal fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor, authInterceptor: AuthInterceptor): OkHttpClient {
        val httpClient = OkHttpClient.Builder()
        httpClient.connectTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClient.readTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)
        httpClient.writeTimeout(Constants.DEFAULT_TIMEOUT.toLong(), TimeUnit.SECONDS)

        httpClient.addInterceptor(authInterceptor)
        httpClient.interceptors().add(httpLoggingInterceptor)

        return httpClient.build()
    }

    /**
     * Returns an instance of AuthInterceptor
     *
     * @return an instance of [AuthInterceptor]
     */
    @Provides
    @Singleton
    internal fun provideAuthInterceptor(): AuthInterceptor {
        return AuthInterceptor()
    }

    /**
     * Returns an instance of [Retrofit]
     *
     * @param okHttpClient represents an instance of [OkHttpClient]
     * @param gson         represents an instance of [Gson]
     * @return an instance of [Retrofit]
     */
    @Provides
    @Singleton
    internal fun provideRetrofitVideo(okHttpClient: OkHttpClient, gson: Gson): Retrofit {
        return Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .build()
    }

    /**
     * Returns an instance of INewsAPI
     *
     * @param retrofit represents an instance of [INewsAPI]
     * @return an instance of [INewsAPI]
     */
    @Provides
    @Singleton
    internal fun provideIPetteServiceVideo(retrofit: Retrofit): INewsAPI {
        return retrofit.create(INewsAPI::class.java)
    }
}
