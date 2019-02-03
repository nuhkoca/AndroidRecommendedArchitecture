package com.nuhkoca.offlineapp.ui.news;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.nuhkoca.offlineapp.BR;
import com.nuhkoca.offlineapp.base.BaseAdapter;
import com.nuhkoca.offlineapp.data.local.entity.News;
import com.nuhkoca.offlineapp.databinding.NewsItemLayoutBinding;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

public class NewsAdapter extends BaseAdapter<NewsAdapter.NewsViewHolder, News> {

    private List<News> mNews;

    @NonNull
    @Override
    public NewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);

        NewsItemLayoutBinding newsItemLayoutBinding = NewsItemLayoutBinding.inflate(inflater, parent, false);
        return new NewsViewHolder(newsItemLayoutBinding.getRoot());
    }

    @Override
    public void onBindViewHolder(@NonNull NewsViewHolder holder, int position) {
        News news = mNews.get(position);

        if (news != null) {
            holder.bindTo(news);
        }
    }

    @Override
    public void setData(List<News> news) {
        mNews = news;
        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        if (mNews == null) return 0;
        return mNews.size();
    }

    class NewsViewHolder extends RecyclerView.ViewHolder {

        private NewsItemLayoutBinding mNewsItemLayoutBinding;

        NewsViewHolder(@NonNull View itemView) {
            super(itemView);

            mNewsItemLayoutBinding = DataBindingUtil.getBinding(itemView);
        }

        void bindTo(News news) {
            mNewsItemLayoutBinding.setVariable(BR.news, news);
            mNewsItemLayoutBinding.executePendingBindings();
        }
    }
}
