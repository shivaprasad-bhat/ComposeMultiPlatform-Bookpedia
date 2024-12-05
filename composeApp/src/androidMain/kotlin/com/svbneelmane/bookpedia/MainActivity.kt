package com.svbneelmane.bookpedia

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview
import io.ktor.client.engine.okhttp.OkHttp

/**
 * Main Activity of the application
 * Application entry point
 * @created by shivaprasad-bhat on 21-Nov-2024
 */
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            App(
                engine = remember {
                    io.ktor.client.engine.okhttp.OkHttp.create()
                }
            )
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    App(
        engine = remember { OkHttp.create() }
    )
}