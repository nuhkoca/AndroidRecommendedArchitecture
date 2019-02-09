package com.nuhkoca.offlineapp.ui.news

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.nuhkoca.offlineapp.BR
import com.nuhkoca.offlineapp.base.BaseAdapter
import com.nuhkoca.offlineapp.data.local.entity.News
import com.nuhkoca.offlineapp.databinding.NewsItemLayoutBinding

class NewsAdapter : BaseAdapter<NewsAdapter.NewsViewHolder, News>() {

    private var mNews: List<News>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)

        val newsItemLayoutBinding = NewsItemLayoutBinding.inflate(inflater, parent, false)
        return NewsViewHolder(newsItemLayoutBinding.root)
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val news = mNews?.get(position)

        news?.let {
            holder.bindTo(it)
        }
    }

    @Suppress("UNCHECKED_CAST")
    override fun setData(data: List<Any>) {
        mNews = data as List<News>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mNews == null) 0 else mNews!!.size
    }

    inner class NewsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val mNewsItemLayoutBinding: NewsItemLayoutBinding? = DataBindingUtil.getBinding(itemView)

        fun bindTo(news: News) {
            mNewsItemLayoutBinding!!.setVariable(BR.news, news)
            mNewsItemLayoutBinding.executePendingBindings()
        }
    }
}
