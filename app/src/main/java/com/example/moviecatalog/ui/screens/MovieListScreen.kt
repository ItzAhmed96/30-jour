package com.example.moviecatalog.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.moviecatalog.data.MovieDataSource
import com.example.moviecatalog.ui.components.MovieCard

@Composable
fun MovieListScreen(
    onMovieClick: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    LazyColumn(
        modifier = modifier,
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(MovieDataSource.movies) { movie ->
            MovieCard(
                movie = movie,
                onMovieClick = onMovieClick
            )
        }
    }
}

