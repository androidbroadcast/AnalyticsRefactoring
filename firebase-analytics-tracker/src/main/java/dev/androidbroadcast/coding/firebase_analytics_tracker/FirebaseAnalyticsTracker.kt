package dev.androidbroadcast.coding.firebase_analytics_tracker

import android.os.Bundle
import com.google.firebase.analytics.FirebaseAnalytics
import dev.androidbroadcast.coding.app_analytics.AnalyticsTracker

class FirebaseAnalyticsTracker(private val analytics: FirebaseAnalytics) : AnalyticsTracker {

    override fun logEvent(name: String, params: Map<String, Any>?) {
        require(name.length in 1..40) {
            "Event name length must be from 1 to 40 symbols"
        }
        analytics.logEvent(name, params?.toFirebaseAnalyticsParams())
    }

    private fun Map<String, Any>.toFirebaseAnalyticsParams(): Bundle {
        return Bundle(size).apply {
            onEach { (key, value) ->
                when (value) {
                    is String -> putString(key, value)
                    is Int -> putInt(key, value)
                    is Long -> putLong(key, value)
                    else -> error("Unsupported param type ${value.javaClass} in key \"$key\"")
                }
            }
        }
    }
}