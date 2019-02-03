package com.nuhkoca.offlineapp.di.module;

import com.nuhkoca.offlineapp.binding.DateParsingBindingAdapter;
import com.nuhkoca.offlineapp.binding.ImageBindingAdapter;
import com.nuhkoca.offlineapp.binding.ListBindingAdapter;
import com.nuhkoca.offlineapp.di.qualifier.DataBinding;

import androidx.databinding.BindingAdapter;
import dagger.Module;
import dagger.Provides;

/**
 * A module that handles {@link BindingAdapter} classes as generic.
 *
 * @author nuhkoca
 */
@Module
public class BindingModule {

    /**
     * Returns an instance of {@link ImageBindingAdapter}
     *
     * @return an instance of {@link ImageBindingAdapter}
     */
    @DataBinding
    @Provides
    ImageBindingAdapter bindsImageBindingAdapter() {
        return new ImageBindingAdapter();
    }

    /**
     * Returns an instance of {@link ListBindingAdapter}
     *
     * @return an instance of {@link ListBindingAdapter}
     */
    @DataBinding
    @Provides
    ListBindingAdapter bindsListBindingAdapter() {
        return new ListBindingAdapter();
    }

    /**
     * Returns an instance of {@link DateParsingBindingAdapter}
     *
     * @return an instance of {@link DateParsingBindingAdapter}
     */
    @DataBinding
    @Provides
    DateParsingBindingAdapter bindsDateParsingBindingAdapter() {
        return new DateParsingBindingAdapter();
    }
}
