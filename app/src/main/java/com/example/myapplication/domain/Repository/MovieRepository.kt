package com.example.myapplication.domain.Repository

import com.example.myapplication.data.model.movie.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>? // null if no movies are cached
    suspend fun updateMovies(): List<Movie>? // null if no movies are cached

}