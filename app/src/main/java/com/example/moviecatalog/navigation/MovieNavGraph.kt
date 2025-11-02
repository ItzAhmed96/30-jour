package com.example.moviecatalog.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.moviecatalog.ui.screens.MovieDetailScreen
import com.example.moviecatalog.ui.screens.MovieListScreen

@Composable
fun MovieNavGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "movieList",
    showBackButton: Boolean = true,
    onMovieSelected: (Int) -> Unit = {}
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable("movieList") {
            MovieListScreen(
                onMovieClick = { movieId ->
                    onMovieSelected(movieId)
                }
            )
        }
        composable("movieDetails/{movieId}") { backStackEntry ->
            val movieId = backStackEntry.arguments?.getString("movieId")?.toIntOrNull() ?: 0
            val movie = com.example.moviecatalog.data.MovieDataSource.movies.find { it.id == movieId }

            MovieDetailScreen(
                movie = movie,
                onBackClick = if (showBackButton) { { navController.popBackStack() } } else null
            )
        }
    }
}