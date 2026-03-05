package com.example.remotecomposesample

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.remote.player.compose.RemoteDocumentPlayer
import androidx.compose.remote.player.core.RemoteDocument
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@SuppressLint("RestrictedApi")
@Composable
fun MyRemoteScreen() {
    val binaryData = remember { createYellowButtonRemoteCompose().encodeToByteArray() }
    val remoteDocument = remember(binaryData) { RemoteDocument(binaryData) }

    if (remoteDocument != null) {
        RemoteDocumentPlayer(
            document = remoteDocument.document,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.Red),
            onAction = { id, res ->
                when (id) {
                    100 -> println("Button Clicked!")
                }
                println("id=${id}, res=${res}")
            },
            documentWidth = 0,
            documentHeight = 0,
            debugMode = 0,
        )
    }
}