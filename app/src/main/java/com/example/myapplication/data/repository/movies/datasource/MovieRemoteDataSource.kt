package com.example.myapplication.data.repository.movies.datasource

import com.example.myapplication.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {
    suspend fun getMovies(): Response<MovieList>
}