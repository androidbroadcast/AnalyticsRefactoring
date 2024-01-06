package dev.androidbroadcast.coding.feature_profile

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import dev.androidbroadcast.coding.core.AppCore
import dev.androidbroadcast.coding.feature_profile.analytics.UserProfileScreenOpenedEvent

@Composable
fun ProfileScreen() {
    LaunchedEffect(key1 = Unit) {
        AppCore.analytics.trackEvent(UserProfileScreenOpenedEvent())
    }
    // Другой код реализации экрана
}

