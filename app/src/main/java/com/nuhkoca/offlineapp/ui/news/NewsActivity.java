package com.nuhkoca.offlineapp.ui.news;

import android.os.Bundle;

import com.nuhkoca.offlineapp.R;
import com.nuhkoca.offlineapp.databinding.ActivityNewsBinding;
import com.nuhkoca.offlineapp.helper.RecyclerViewItemDecoration;

import javax.inject.Inject;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import dagger.android.support.DaggerAppCompatActivity;

public class NewsActivity extends DaggerAppCompatActivity {

    @Inject
    ViewModelProvider.Factory viewModelFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityNewsBinding activityNewsBinding = DataBindingUtil.setContentView(this, R.layout.activity_news);
        NewsViewModel newsViewModel = ViewModelProviders.of(this, viewModelFactory).get(NewsViewModel.class);
        activityNewsBinding.rvNews.setAdapter(new NewsAdapter());
        activityNewsBinding.rvNews.addItemDecoration(new RecyclerViewItemDecoration(getApplicationContext(), 1, 0));
        activityNewsBinding.setViewmodel(newsViewModel);
        activityNewsBinding.setLifecycleOwner(this);
    }
}
