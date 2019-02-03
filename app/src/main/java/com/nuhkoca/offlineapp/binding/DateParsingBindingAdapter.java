package com.nuhkoca.offlineapp.binding;

import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

import androidx.databinding.BindingAdapter;

public class DateParsingBindingAdapter {

    public DateParsingBindingAdapter() {
    }

    @BindingAdapter(value = "android:date")
    public void bindDate(TextView target, Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat("MMM dd", new Locale("tr", "TR", "tr"));
        target.setText(formatter.format(date));
    }
}
