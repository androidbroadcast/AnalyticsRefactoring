package dev.androidbroadcast.coding.app_analytics

/**
 * Абстракция над аналитикой для независимости от какой либо технологии или платформы
 */
interface AnalyticsTracker {

    fun logEvent(name: String, params: Map<String, Any>? = null)
}

// Метод не сделан частью интерфейса AnalyticsTracker чтобы интерфейс был минимальным по API
fun AnalyticsTracker.logEvent(event: Event) {
    logEvent(event.name, event.params)
}
