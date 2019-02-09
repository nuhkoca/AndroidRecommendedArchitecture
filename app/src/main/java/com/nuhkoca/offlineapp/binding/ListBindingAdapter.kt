package com.nuhkoca.offlineapp.binding

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.nuhkoca.offlineapp.base.BaseAdapter
import com.nuhkoca.offlineapp.repository.Resource

class ListBindingAdapter {

    @Suppress("UNCHECKED_CAST")
    @BindingAdapter(value = ["android:resource"])
    fun setResource(recyclerView: RecyclerView, resource: Resource<*>) {
        val adapter = recyclerView.adapter ?: return

        resource.data?.let {
            if (adapter is BaseAdapter<*, *>) {
                adapter.setData(it as List<Any>)
            }
        }
    }
}
