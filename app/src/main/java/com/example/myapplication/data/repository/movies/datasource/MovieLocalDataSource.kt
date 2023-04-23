package com.example.myapplication.data.repository.movies.datasource

import com.example.myapplication.data.model.movie.Movie


interface MovieLocalDataSource {
    suspend fun getMoviesFromDataBase(): List<Movie>?
    suspend fun saveMoviesToDataBase(movies: List<Movie>)
    suspend fun clearAll()

}