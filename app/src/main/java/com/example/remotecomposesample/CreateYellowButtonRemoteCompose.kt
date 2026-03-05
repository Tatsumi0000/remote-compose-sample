package com.example.remotecomposesample

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.compose.remote.creation.RemoteComposeContextAndroid
import androidx.compose.remote.creation.RemoteComposeWriter
import androidx.compose.remote.creation.actions.HostAction
import androidx.compose.remote.creation.modifiers.RecordingModifier
import androidx.compose.remote.creation.platform.AndroidxRcPlatformServices

/**
 * Remote Compose のデータを作る側
 */
@SuppressLint("RestrictedApi")
fun createYellowButtonRemoteCompose(): RemoteComposeWriter {
    return RemoteComposeContextAndroid(
        width = 500,
        height = 300,
        contentDescription = "Yellow Button",
        apiLevel = 6,
        profiles = 0,
        platform = AndroidxRcPlatformServices(),
        ) {
        root {
            box(RecordingModifier()
                .background(Color.YELLOW)
                .onClick(HostAction(100))
            ) {
                text("This is Button!")
            }
        }
    }.writer
}