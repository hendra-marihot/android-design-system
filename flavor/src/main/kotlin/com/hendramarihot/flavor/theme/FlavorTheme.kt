package com.hendramarihot.flavor.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalFlavorTokens = staticCompositionLocalOf { FlavorTokens.Default }

@Composable
fun FlavorTheme(
    tokens: FlavorTokens = FlavorTokens.Default,
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(LocalFlavorTokens provides tokens) {
        MaterialTheme(content = content)
    }
}

object Flavor {
    val tokens: FlavorTokens
        @Composable get() = LocalFlavorTokens.current
}
