package dev.androidbroadcast.coding.badanalytics

import android.app.Application
import com.google.firebase.analytics.FirebaseAnalytics
import dev.androidbroadcast.coding.app_analytics.AppAnalytics
import dev.androidbroadcast.coding.core.initApp
import dev.androidbroadcast.coding.firebase_analytics_tracker.FirebaseAnalyticsTracker

class BadApp : Application() {

    override fun onCreate() {
        super.onCreate()
        initApp(AppAnalytics(FirebaseAnalyticsTracker(FirebaseAnalytics.getInstance(this))))
    }
}