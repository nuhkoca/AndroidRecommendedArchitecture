package com.nuhkoca.offlineapp.di.component

import androidx.databinding.DataBindingComponent
import com.nuhkoca.offlineapp.binding.DateParsingBindingAdapter
import com.nuhkoca.offlineapp.binding.ImageBindingAdapter
import com.nuhkoca.offlineapp.binding.ListBindingAdapter
import com.nuhkoca.offlineapp.di.module.BindingModule
import com.nuhkoca.offlineapp.di.scope.DataBinding
import dagger.Component

@DataBinding
@Component(dependencies = [AppComponent::class], modules = [BindingModule::class])
interface BindingComponent: DataBindingComponent {

    override fun getImageBindingAdapter(): ImageBindingAdapter?

    override fun getListBindingAdapter(): ListBindingAdapter?

    override fun getDateParsingBindingAdapter(): DateParsingBindingAdapter?
}