package com.nuhkoca.offlineapp.ui.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.nuhkoca.offlineapp.ui.news.NewsActivity;

import dagger.android.support.DaggerAppCompatActivity;

public class SplashActivity extends DaggerAppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        new Handler().postDelayed(() -> startActivity(new Intent(SplashActivity.this, NewsActivity.class)), 1500);
    }
}
