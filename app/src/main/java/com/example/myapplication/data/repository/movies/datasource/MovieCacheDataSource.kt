package com.example.myapplication.data.repository.movies.datasource

import com.example.myapplication.data.model.movie.Movie

interface MovieCacheDataSource {
    suspend fun getMoviesFromCash(): List<Movie>?
    suspend fun saveMoviesToCash(movies: List<Movie>)

}