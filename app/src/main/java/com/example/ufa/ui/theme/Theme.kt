package com.example.ufa.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val UfaColorScheme = lightColorScheme(
    primary = UfaPrimary,
    onPrimary = UfaSurface,
    primaryContainer = UfaPrimarySoft,
    onPrimaryContainer = UfaPrimary,
    secondary = UfaAccent,
    background = UfaSurface,
    onBackground = UfaText,
    surface = UfaSurface,
    onSurface = UfaText,
    surfaceVariant = UfaBg,
    onSurfaceVariant = UfaTextMuted,
    outline = UfaBorder,
    outlineVariant = UfaBorder
)

@Composable
fun UfaTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = UfaColorScheme,
        typography = Typography,
        content = content
    )
}