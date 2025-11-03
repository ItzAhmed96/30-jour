package com.example.moviecatalog.ui.theme

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.moviecatalog.data.Movie

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieScreen(movies: List<Movie>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("🎬 30 Movies Catalog") },
                colors = TopAppBarDefaults.smallTopAppBarColors(
                    containerColor = Color(0xFF006E51),
                    titleContentColor = Color.White
                )
            )
        }
    ) { paddingValues ->

        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(Color(0xFFF7F6F3))
                .padding(paddingValues)
        ) {
            items(movies) { movie ->
                MovieCard(movie)
            }
        }
    }
}

@Composable
fun MovieCard(movie: Movie) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { expanded = !expanded },
        colors = CardDefaults.cardColors(containerColor = Color.White),
        elevation = CardDefaults.cardElevation(8.dp),
        shape = MaterialTheme.shapes.medium
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(
                text = movie.title,
                fontWeight = androidx.compose.ui.text.font.FontWeight.Bold,
                fontSize = 18.sp
            )

            Spacer(modifier = Modifier.height(8.dp))

            Image(
                painter = painterResource(id = movie.imageRes),
                contentDescription = movie.title,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            )

            AnimatedVisibility(visible = expanded) {
                Text(
                    text = movie.description,
                    modifier = Modifier.padding(top = 8.dp),
                    fontSize = 14.sp
                )
            }
        }
    }
}
