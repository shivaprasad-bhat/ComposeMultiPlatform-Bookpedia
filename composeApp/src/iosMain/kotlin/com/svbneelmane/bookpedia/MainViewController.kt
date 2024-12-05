package com.svbneelmane.bookpedia

import androidx.compose.ui.window.ComposeUIViewController
import com.svbneelmane.bookpedia.di.initKoin

fun MainViewController() = ComposeUIViewController(
    configure = {
        initKoin()
    }
) {
    App()
}