package com.example.moviecatalog.ui

import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
@Composable
fun MovieApp(
    modifier: Modifier = Modifier
) {
    val windowSize = calculateWindowSizeClass(
        activity = TODO()
    )

    when (windowSize.widthSizeClass) {
        WindowWidthSizeClass.Compact -> {
            MovieAppPortrait(modifier)
        }
        WindowWidthSizeClass.Medium -> {
            MovieAppMedium(modifier)
        }
        WindowWidthSizeClass.Expanded -> {
            MovieAppExpanded(modifier)
        }
    }
}