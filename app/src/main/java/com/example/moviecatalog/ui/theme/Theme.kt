package com.example.moviecatalog.ui.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColorScheme = lightColorScheme(
    primary = androidx.compose.ui.graphics.Color(0xFF0066CC),
    secondary = androidx.compose.ui.graphics.Color(0xFF66BB6A),
    tertiary = androidx.compose.ui.graphics.Color(0xFF8E24AA)
)

@Composable
fun MovieCatalogTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = LightColorScheme,
        typography = MaterialTheme.typography,
        content = content
    )
}