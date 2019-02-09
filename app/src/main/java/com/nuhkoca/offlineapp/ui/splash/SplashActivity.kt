package com.nuhkoca.offlineapp.ui.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler

import com.nuhkoca.offlineapp.ui.news.NewsActivity

import dagger.android.support.DaggerAppCompatActivity

class SplashActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Handler().postDelayed({ startActivity(Intent(this@SplashActivity, NewsActivity::class.java)) }, 1500)
    }
}
