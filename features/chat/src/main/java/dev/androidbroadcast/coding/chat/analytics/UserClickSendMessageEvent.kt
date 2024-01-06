package dev.androidbroadcast.coding.chat.analytics

import androidx.annotation.IntRange
import dev.androidbroadcast.coding.app_analytics.Event

internal data class UserClickSendMessageEvent(@IntRange(from = 1) val count: Int) : Event.Simple(
    name = EVENT_NAME,
    params = mapOf(PARAM_TIMES to count),
) {

    init {
        require(count > 0) { "Count must be positive" }
    }

    companion object {

        const val EVENT_NAME = "userClickSendMessage"
        const val PARAM_TIMES = "times"
    }
}