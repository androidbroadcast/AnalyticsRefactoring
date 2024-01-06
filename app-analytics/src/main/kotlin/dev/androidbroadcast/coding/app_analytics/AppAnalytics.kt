package dev.androidbroadcast.coding.app_analytics

class AppAnalytics(private val trackers: List<AnalyticsTracker>) {

    constructor(tracker: AnalyticsTracker): this(listOf(tracker))

    init {
        check(trackers.isNotEmpty()) {
            "Trackers are empty"
        }
    }

    fun trackEvent(event: Event) {
        trackers.forEach { tracker -> tracker.logEvent(event) }
    }
}