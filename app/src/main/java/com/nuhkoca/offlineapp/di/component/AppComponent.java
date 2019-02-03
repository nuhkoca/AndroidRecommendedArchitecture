package com.nuhkoca.offlineapp.di.component;

import android.app.Application;


import com.nuhkoca.offlineapp.OfflineApp;
import com.nuhkoca.offlineapp.di.module.AppModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

/**
 * A main {@link Component} that conducts everything for injection
 *
 * @author nuhkoca
 */
@Singleton
@Component(modules = {AndroidSupportInjectionModule.class, AppModule.class})
public interface AppComponent extends AndroidInjector<OfflineApp> {

    /**
     * Injects the main app
     *
     * @param instance represents an instance of of {@link OfflineApp}
     */
    @Override
    void inject(OfflineApp instance);

    /**
     * Builder of {@link AppComponent}
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
