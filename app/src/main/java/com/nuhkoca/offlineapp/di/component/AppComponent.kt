package com.nuhkoca.offlineapp.di.component

import android.app.Application


import com.nuhkoca.offlineapp.OfflineApp
import com.nuhkoca.offlineapp.di.module.AppModule

import javax.inject.Singleton

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule

/**
 * A main [Component] that conducts everything for injection
 *
 * @author nuhkoca
 */
@Singleton
@Component(modules = [AndroidSupportInjectionModule::class, AppModule::class])
interface AppComponent : AndroidInjector<OfflineApp> {

    /**
     * Injects the main app
     *
     * @param instance represents an instance of of [OfflineApp]
     */
    override fun inject(instance: OfflineApp)

    /**
     * Builder of [AppComponent]
     */
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): AppComponent.Builder

        fun build(): AppComponent
    }
}
