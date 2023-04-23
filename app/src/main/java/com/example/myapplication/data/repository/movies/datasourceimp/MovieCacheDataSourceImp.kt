package com.example.myapplication.data.repository.movies.datasourceimp

import com.example.myapplication.data.model.movie.Movie
import com.example.myapplication.data.repository.movies.datasource.MovieCacheDataSource

class MovieCacheDataSourceImp : MovieCacheDataSource {
    private var movieList = ArrayList<Movie>()
    override suspend fun getMoviesFromCash(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCash(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}