package com.example.moviecatalog.data

data class Movie(
    val id: Int,
    val title: String,
    val year: Int,
    val genre: String,
    val rating: Float,
    val duration: String,
    val description: String,
    val imageUrl: String = ""
)

object MovieDataSource {
    val movies = listOf(
        Movie(
            id = 1,
            title = "Inception",
            year = 2010,
            genre = "Sci-Fi, Action",
            rating = 8.8f,
            duration = "2h 28m",
            description = "A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.",
            imageUrl = "https://images.unsplash.com/photo-1635805737707-575885ab0820?w=400"
        ),
        Movie(
            id = 2,
            title = "The Shawshank Redemption",
            year = 1994,
            genre = "Drama",
            rating = 9.3f,
            duration = "2h 22m",
            description = "Two imprisoned men bond over a number of years, finding solace and eventual redemption through acts of common decency.",
            imageUrl = "https://images.unsplash.com/photo-1489599809505-f2f140257d46?w=400"
        ),
        Movie(
            id = 3,
            title = "The Dark Knight",
            year = 2008,
            genre = "Action, Crime, Drama",
            rating = 9.0f,
            duration = "2h 32m",
            description = "When the menace known as the Joker wreaks havoc and chaos on the people of Gotham, Batman must accept one of the greatest psychological and physical tests.",
            imageUrl = "https://images.unsplash.com/photo-1509347528160-9a9e33742cdb?w=400"
        ),
        Movie(
            id = 4,
            title = "Pulp Fiction",
            year = 1994,
            genre = "Crime, Drama",
            rating = 8.9f,
            duration = "2h 34m",
            description = "The lives of two mob hitmen, a boxer, a gangster and his wife, and a pair of diner bandits intertwine in four tales of violence and redemption.",
            imageUrl = "https://images.unsplash.com/photo-1489599809505-f2f140257d46?w=400"
        ),
        Movie(
            id = 5,
            title = "Forrest Gump",
            year = 1994,
            genre = "Drama, Romance",
            rating = 8.8f,
            duration = "2h 22m",
            description = "The presidencies of Kennedy and Johnson, the Vietnam War, the Watergate scandal and other historical events unfold from the perspective of an Alabama man.",
            imageUrl = "https://images.unsplash.com/photo-1489599809505-f2f140257d46?w=400"
        ),
        Movie(
            id = 6,
            title = "The Matrix",
            year = 1999,
            genre = "Action, Sci-Fi",
            rating = 8.7f,
            duration = "2h 16m",
            description = "A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.",
            imageUrl = "https://images.unsplash.com/photo-1635805737707-575885ab0820?w=400"
        )
    )
}