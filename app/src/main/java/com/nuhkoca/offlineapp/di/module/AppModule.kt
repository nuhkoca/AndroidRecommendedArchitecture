package com.nuhkoca.offlineapp.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable

/**
 * A [Module] that injects general stuffs and includes other modules
 *
 * @author nuhkoca
 */
@Module(includes = [ActivityBuilder::class, ContextModule::class, ViewModelModule::class, RoomModule::class, NetModule::class])
class AppModule {

    /**
     * Returns an instance of [CompositeDisposable]
     *
     * @return an instance of [CompositeDisposable]
     */
    @Provides
    internal fun provideCompositeDisposable(): CompositeDisposable {
        return CompositeDisposable()
    }
}
