package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviecatalog.data.MovieDataSource
import com.example.moviecatalog.navigation.MovieNavGraph
import com.example.moviecatalog.ui.screens.MovieDetailScreen

@Composable
fun MovieAppExpanded(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentMovieId = backStackEntry?.arguments?.getString("movieId")?.toIntOrNull()
    val currentMovie = MovieDataSource.movies.find { it.id == currentMovieId }

    Row(modifier = modifier) {
        // List (1/4 of screen)
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxHeight()
        ) {
            MovieNavGraph(
                navController = navController,
                startDestination = "movieList",
                showBackButton = false,
                onMovieSelected = { movieId ->
                    navController.navigate("movieDetails/$movieId") {
                        launchSingleTop = true
                    }
                }
            )
        }

        // Details (3/4 of screen)
        Box(
            modifier = Modifier
                .weight(3f)
                .fillMaxHeight()
        ) {
            if (currentMovie != null) {
                MovieDetailScreen(
                    movie = currentMovie,
                    onBackClick = null,
                    modifier = Modifier.fillMaxSize()
                )
            } else {
                Box(
                    modifier = Modifier.fillMaxSize(),
                    contentAlignment = androidx.compose.ui.Alignment.Center
                ) {
                    Text(
                        "Select a movie to see details",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}