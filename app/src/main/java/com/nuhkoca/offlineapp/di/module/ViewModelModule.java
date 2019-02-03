package com.nuhkoca.offlineapp.di.module;

import com.nuhkoca.offlineapp.di.qualifier.ViewModelKey;
import com.nuhkoca.offlineapp.ui.news.NewsViewModel;
import com.nuhkoca.offlineapp.vm.NewsViewModelFactory;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * A {@link Module} that injects ViewModels
 *
 * @author nuhkoca
 */
@Module
public abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel.class)
    abstract ViewModel bindNewsViewModel(NewsViewModel newsViewModel);

    /**
     * Returns an instance of {@link NewsViewModelFactory}
     *
     * @param newsViewModelFactory an instance of {@link NewsViewModelFactory}
     * @return an instance of {@link NewsViewModelFactory}
     */
    @Binds
    abstract ViewModelProvider.Factory bindsNewsViewModelFactory(@NonNull NewsViewModelFactory newsViewModelFactory);
}
