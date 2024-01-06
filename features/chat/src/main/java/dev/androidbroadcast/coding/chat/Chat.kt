package dev.androidbroadcast.coding.chat

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import dev.androidbroadcast.coding.chat.analytics.NewTextMessageCreatedEvent
import dev.androidbroadcast.coding.chat.analytics.UserClickSendMessageEvent
import dev.androidbroadcast.coding.core.AppCore

@Composable
fun ChatScreen() {
    Column {
        var count = 0
        var message: String by rememberSaveable { mutableStateOf("") }
        TextField(value = message, onValueChange = { message = it })
        Button(onClick = {
            with(AppCore.analytics) {
                trackEvent(UserClickSendMessageEvent(++count))
                trackEvent(NewTextMessageCreatedEvent(message.length))
            }
        }) {
            Text("Send message")
        }
    }
}

