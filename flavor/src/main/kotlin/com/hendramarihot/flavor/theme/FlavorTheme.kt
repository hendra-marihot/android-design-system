package com.hendramarihot.flavor.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf

val LocalFlavorTokens = staticCompositionLocalOf { FlavorTokens.Default }

@Composable
fun FlavorTheme(
    tokens: FlavorTokens = FlavorTokens.Default,
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colorScheme = if (darkTheme) darkColorScheme() else lightColorScheme()
    CompositionLocalProvider(LocalFlavorTokens provides tokens) {
        MaterialTheme(colorScheme = colorScheme, content = content)
    }
}

object Flavor {
    val tokens: FlavorTokens
        @Composable get() = LocalFlavorTokens.current
}
