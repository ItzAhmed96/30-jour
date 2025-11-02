package com.example.moviecatalog.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.example.moviecatalog.navigation.MovieNavGraph

@Composable
fun MovieAppPortrait(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()

    MovieNavGraph(
        navController = navController,
        modifier = modifier,
        onMovieSelected = { movieId ->
            navController.navigate("movieDetails/$movieId")
        }
    )
}