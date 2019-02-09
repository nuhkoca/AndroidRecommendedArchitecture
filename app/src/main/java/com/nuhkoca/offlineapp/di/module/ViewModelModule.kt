package com.nuhkoca.offlineapp.di.module

import com.nuhkoca.offlineapp.di.qualifier.ViewModelKey
import com.nuhkoca.offlineapp.ui.news.NewsViewModel
import com.nuhkoca.offlineapp.vm.NewsViewModelFactory
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * A [Module] that injects ViewModels
 *
 * @author nuhkoca
 */
@Module
abstract class ViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(NewsViewModel::class)
    internal abstract fun bindNewsViewModel(newsViewModel: NewsViewModel): ViewModel

    /**
     * Returns an instance of [NewsViewModelFactory]
     *
     * @param newsViewModelFactory an instance of [NewsViewModelFactory]
     * @return an instance of [NewsViewModelFactory]
     */
    @Binds
    internal abstract fun bindsNewsViewModelFactory(newsViewModelFactory: NewsViewModelFactory): ViewModelProvider.Factory
}
