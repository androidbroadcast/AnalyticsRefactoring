package dev.androidbroadcast.coding.chat.analytics

import androidx.annotation.IntRange
import dev.androidbroadcast.coding.app_analytics.Event

internal class NewTextMessageCreatedEvent(val textLength: Int): Event.Simple(
    name = EVENT_NAME,
    params = mapOf(PARAM_TEXT_LENGTH to textLength),
) {

    companion object {

        const val EVENT_NAME = "newTextMessageCreated"
        const val PARAM_TEXT_LENGTH = "textLength"
    }
}