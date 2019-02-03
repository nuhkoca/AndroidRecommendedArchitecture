package com.nuhkoca.offlineapp.di.module;

import com.nuhkoca.offlineapp.di.scope.PerActivity;
import com.nuhkoca.offlineapp.ui.news.NewsActivity;
import com.nuhkoca.offlineapp.ui.splash.SplashActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

/**
 * A {@link Module} that injects activities
 *
 * @author nuhkoca
 */
@Module
public abstract class ActivityBuilder {

    /**
     * Injects {@link SplashActivity}
     *
     * @return an instance of {@link SplashActivity}
     */
    @PerActivity
    @ContributesAndroidInjector
    abstract SplashActivity contributesSplashActivityInjector();

    /**
     * Injects {@link NewsActivity}
     *
     * @return an instance of {@link NewsActivity}
     */
    @PerActivity
    @ContributesAndroidInjector
    abstract NewsActivity contributesNewsActivityInjector();
}
