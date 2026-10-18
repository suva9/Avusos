package com.avusos.app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.avusos.app.ui.AvusApp
import com.avusos.app.ui.AvusTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            AvusTheme {
                AvusApp()
            }
        }
    }
}
