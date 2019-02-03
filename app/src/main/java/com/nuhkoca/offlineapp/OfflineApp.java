package com.nuhkoca.offlineapp;

import com.nuhkoca.offlineapp.di.component.AppComponent;
import com.nuhkoca.offlineapp.di.component.BindingComponent;
import com.nuhkoca.offlineapp.di.component.DaggerAppComponent;
import com.nuhkoca.offlineapp.di.component.DaggerBindingComponent;

import androidx.databinding.DataBindingUtil;
import dagger.android.AndroidInjector;
import dagger.android.support.DaggerApplication;

/**
 * An {@link DaggerApplication} that handles Dagger setup.
 *
 * @author nuhkoca
 */
public class OfflineApp extends DaggerApplication {

    /**
     * Returns the injector
     *
     * @return the injector
     */
    @Override
    protected AndroidInjector<? extends DaggerApplication> applicationInjector() {
        AppComponent appComponent = DaggerAppComponent.builder().application(this).build();
        appComponent.inject(this);

        BindingComponent bindingComponent = DaggerBindingComponent.builder().appComponent(appComponent).build();
        DataBindingUtil.setDefaultComponent(bindingComponent);

        return appComponent;
    }
}
