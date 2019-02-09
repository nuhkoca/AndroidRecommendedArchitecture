package com.nuhkoca.offlineapp.di.module

import com.nuhkoca.offlineapp.di.scope.PerActivity
import com.nuhkoca.offlineapp.ui.news.NewsActivity
import com.nuhkoca.offlineapp.ui.splash.SplashActivity

import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * A [Module] that injects activities
 *
 * @author nuhkoca
 */
@Module
abstract class ActivityBuilder {

    /**
     * Injects [SplashActivity]
     *
     * @return an instance of [SplashActivity]
     */
    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributesSplashActivityInjector(): SplashActivity

    /**
     * Injects [NewsActivity]
     *
     * @return an instance of [NewsActivity]
     */
    @PerActivity
    @ContributesAndroidInjector
    internal abstract fun contributesNewsActivityInjector(): NewsActivity
}
