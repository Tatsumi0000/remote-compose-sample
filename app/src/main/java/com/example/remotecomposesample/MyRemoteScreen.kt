package com.example.remotecomposesample

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.remote.player.compose.RemoteDocumentPlayer
import androidx.compose.remote.player.core.RemoteDocument
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier

@SuppressLint("RestrictedApi")
@Composable
fun MyRemoteScreen() {
    val binaryData = remember { createYellowButtonRemoteCompose().encodeToByteArray() }
    val remoteDocument = remember(binaryData) { RemoteDocument(binaryData) }

    if (remoteDocument != null) {
        RemoteDocumentPlayer(
            document = remoteDocument.document,
            modifier = Modifier,
            onAction = { id, res ->
                when (id) {
                    100 -> println("Button Clicked!")
                }
                println("id=${id}, res=${res}")
            },
            documentWidth = 50,
            documentHeight = 50,
            debugMode = 0,
        )
    }
}