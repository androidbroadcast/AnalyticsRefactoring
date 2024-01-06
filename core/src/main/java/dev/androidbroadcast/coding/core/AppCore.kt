package dev.androidbroadcast.coding.core

import dev.androidbroadcast.coding.app_analytics.AppAnalytics

object AppCore {

    internal var appAnalytics: AppAnalytics? = null

    val analytics: AppAnalytics
        get() = checkNotNull(appAnalytics)
}

private var isInitDone = false

@Synchronized
fun initApp(
    appAnalytics: AppAnalytics
) {
    check(!isInitDone) {
        "Init can be completed only once per app process"
    }
    isInitDone = true
    AppCore.appAnalytics = appAnalytics
}