package com.nuhkoca.offlineapp.binding

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.text.SimpleDateFormat
import java.util.*

class DateParsingBindingAdapter {

    @BindingAdapter(value = ["android:date"])
    fun bindDate(target: TextView, date: Date) {
        val formatter = SimpleDateFormat("MMM dd", Locale("tr", "TR", "tr"))
        target.text = formatter.format(date)
    }
}
