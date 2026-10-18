package com.avusos.app.ui

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val AvusColors = darkColorScheme(
    primary = Color(0xFF00E5FF),
    onPrimary = Color.Black,
    background = Color(0xFF0B0F14),
    onBackground = Color(0xFFE6EDF3),
    surface = Color(0xFF141A22),
    onSurface = Color(0xFFE6EDF3),
    surfaceVariant = Color(0xFF202833),
    onSurfaceVariant = Color(0xFF8B98A5)
)

@Composable
fun AvusTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = AvusColors,
        content = content
    )
}
