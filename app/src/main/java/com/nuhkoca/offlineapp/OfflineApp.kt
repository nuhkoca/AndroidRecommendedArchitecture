package com.nuhkoca.offlineapp

import androidx.databinding.DataBindingUtil
import com.nuhkoca.offlineapp.di.component.DaggerAppComponent
import com.nuhkoca.offlineapp.di.component.DaggerBindingComponent
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication

/**
 * An [DaggerApplication] that handles Dagger setup.
 *
 * @author nuhkoca
 */
class OfflineApp : DaggerApplication() {

    /**
     * Returns the injector
     *
     * @return the injector
     */
    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)

        val bindingComponent = DaggerBindingComponent.builder().appComponent(appComponent).build()
        DataBindingUtil.setDefaultComponent(bindingComponent)

        return appComponent
    }
}
