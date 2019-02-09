package com.nuhkoca.offlineapp.binding

import android.text.TextUtils
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import com.nuhkoca.offlineapp.di.module.NewsGlide

/**
 * A [BindingAdapter] to bind images into ImageViews.
 *
 * @author nuhkoca
 */
/**
 * A default constructor that gets several dependents
 */
class ImageBindingAdapter {

    /**
     * A [BindingAdapter] method that binds image into view
     *
     * @param view represents an [ImageView]
     * @param url  represents image url
     */
    @BindingAdapter(value = ["android:src"])
    fun bindImage(view: ImageView, url: String?) {
        if (!TextUtils.isEmpty(url) || url == null) {
           NewsGlide.with(view.context)
                    .asBitmap()
                    .load(url)
                    .into(view)
        }
    }
}
