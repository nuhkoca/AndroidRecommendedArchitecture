package com.nuhkoca.offlineapp.di.module

import com.nuhkoca.offlineapp.binding.DateParsingBindingAdapter
import com.nuhkoca.offlineapp.binding.ImageBindingAdapter
import com.nuhkoca.offlineapp.binding.ListBindingAdapter
import com.nuhkoca.offlineapp.di.qualifier.DataBinding

import androidx.databinding.BindingAdapter
import dagger.Module
import dagger.Provides

/**
 * A module that handles [BindingAdapter] classes as generic.
 *
 * @author nuhkoca
 */
@Module
class BindingModule {

    /**
     * Returns an instance of [ImageBindingAdapter]
     *
     * @return an instance of [ImageBindingAdapter]
     */
    @DataBinding
    @Provides
    internal fun bindsImageBindingAdapter(): ImageBindingAdapter {
        return ImageBindingAdapter()
    }

    /**
     * Returns an instance of [ListBindingAdapter]
     *
     * @return an instance of [ListBindingAdapter]
     */
    @DataBinding
    @Provides
    internal fun bindsListBindingAdapter(): ListBindingAdapter {
        return ListBindingAdapter()
    }

    /**
     * Returns an instance of [DateParsingBindingAdapter]
     *
     * @return an instance of [DateParsingBindingAdapter]
     */
    @DataBinding
    @Provides
    internal fun bindsDateParsingBindingAdapter(): DateParsingBindingAdapter {
        return DateParsingBindingAdapter()
    }
}
