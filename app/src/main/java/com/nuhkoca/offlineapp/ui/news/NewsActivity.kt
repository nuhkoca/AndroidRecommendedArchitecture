package com.nuhkoca.offlineapp.ui.news

import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.nuhkoca.offlineapp.R
import com.nuhkoca.offlineapp.databinding.ActivityNewsBinding
import com.nuhkoca.offlineapp.helper.RecyclerViewItemDecoration
import com.nuhkoca.offlineapp.util.ext.get
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject

class NewsActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val activityNewsBinding = DataBindingUtil.setContentView<ActivityNewsBinding>(this, R.layout.activity_news)
        val newsViewModel: NewsViewModel = viewModelFactory.get(this)
        activityNewsBinding.run {
            rvNews.adapter = NewsAdapter()
            rvNews.addItemDecoration(RecyclerViewItemDecoration(applicationContext, 1, 0))
            viewmodel = newsViewModel
            lifecycleOwner = this@NewsActivity
        }
    }
}
