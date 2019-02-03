package com.nuhkoca.offlineapp.binding;

import com.nuhkoca.offlineapp.base.BaseAdapter;
import com.nuhkoca.offlineapp.repository.Resource;

import java.util.List;

import androidx.databinding.BindingAdapter;
import androidx.recyclerview.widget.RecyclerView;

public class ListBindingAdapter {

    public ListBindingAdapter() {
    }

    @SuppressWarnings("unchecked")
    @BindingAdapter(value = "android:resource")
    public void setResource(RecyclerView recyclerView, Resource resource) {
        RecyclerView.Adapter adapter = recyclerView.getAdapter();
        if (adapter == null)
            return;

        if (resource == null || resource.data == null)
            return;

        if (adapter instanceof BaseAdapter) {
            ((BaseAdapter) adapter).setData((List) resource.data);
        }
    }
}
