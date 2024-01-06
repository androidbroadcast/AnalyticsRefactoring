package dev.androidbroadcast.coding.feature_profile.analytics

import dev.androidbroadcast.coding.app_analytics.Event

internal data class UserProfileScreenOpenedEvent(
    val from: String? = null
) : Event.Simple(
    name = NAME,
    params = from?.let { mapOf(PARAM_FROM to it) }
) {

    companion object {

        const val NAME = "userProfileScreenOpened"
        const val PARAM_FROM = "from"
    }
}


//Альтернативная реализация через метод
fun userProfileScreenOpenedEvent(from: String? = null): Event {
    return Event.Simple(
        name = USER_PROFILE_SCREEN_OPENED_NAME,
        params = from?.let { mapOf(PARAM_FROM to it) }
    )
}


private const val USER_PROFILE_SCREEN_OPENED_NAME = "userProfileScreenOpened"
private const val PARAM_FROM = "from"


// Альтернативная реализация через реализацию интерфейса
private data class UserProfileScreenOpenedEvent2(
    val from: String? = null
) : Event {

    override val name: String = NAME

    override val params: Map<String, Any>? = from?.let { mapOf(PARAM_FROM to it) }

    companion object {

        const val NAME = "userProfileScreenOpened"
        const val PARAM_FROM = "from"
    }
}