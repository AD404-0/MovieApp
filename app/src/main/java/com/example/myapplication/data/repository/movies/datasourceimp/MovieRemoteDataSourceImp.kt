package com.example.myapplication.data.repository.movies.datasourceimp

import com.example.myapplication.data.api.TMDBService
import com.example.myapplication.data.model.movie.MovieList
import com.example.myapplication.data.repository.movies.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImp(
    private val tmbdService: TMDBService,
    private val apikey: String
) : MovieRemoteDataSource {
    override suspend fun getMovies(): Response<MovieList> {
        return tmbdService.getPopularMovies(apikey)
    }
}

