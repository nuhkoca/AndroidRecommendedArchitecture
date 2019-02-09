package com.nuhkoca.offlineapp.ui.news

import com.nuhkoca.offlineapp.data.local.entity.News
import com.nuhkoca.offlineapp.repository.Resource

import javax.inject.Inject
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.nuhkoca.offlineapp.repository.UseCaseLiveData

class NewsViewModel @Inject
internal constructor(newsUseCase: NewsUseCase) : ViewModel() {
    val news: LiveData<Resource<List<News>>> = newsUseCase.execute(UseCaseLiveData.None())
}
