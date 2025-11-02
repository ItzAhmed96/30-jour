package com.example.moviecatalog.ui

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.moviecatalog.data.MovieDataSource
import com.example.moviecatalog.navigation.MovieNavGraph
import com.example.moviecatalog.ui.screens.MovieDetailScreen

@Composable
fun MovieAppMedium(
    modifier: Modifier = Modifier
) {
    val navController = rememberNavController()
    val backStackEntry by navController.currentBackStackEntryAsState()

    val currentMovieId = backStackEntry?.arguments?.getString("movieId")?.toIntOrNull()
    val currentMovie = MovieDataSource.movies.find { it.id == currentMovieId }

    Row(modifier = modifier) {
        // Navigation Rail
        NavigationRail(
            modifier = Modifier.fillMaxHeight()
        ) {
            // You can add navigation items here if needed
        }

        // List (1/3 of screen)
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

        // Details (2/3 of screen)
        Box(
            modifier = Modifier
                .weight(2f)
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
                        "Select a movie",
                        style = MaterialTheme.typography.bodyLarge,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        }
    }
}