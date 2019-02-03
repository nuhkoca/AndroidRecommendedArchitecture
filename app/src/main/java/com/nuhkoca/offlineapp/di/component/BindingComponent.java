package com.nuhkoca.offlineapp.di.component;


import com.nuhkoca.offlineapp.di.module.BindingModule;
import com.nuhkoca.offlineapp.di.qualifier.DataBinding;

import androidx.databinding.DataBindingComponent;
import dagger.Component;

@DataBinding
@Component(dependencies = AppComponent.class, modules = BindingModule.class)
public interface BindingComponent extends DataBindingComponent {
}
