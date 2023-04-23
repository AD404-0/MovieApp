package com.example.myapplication.data.repository.movies

import com.example.myapplication.data.model.movie.Movie
import com.example.myapplication.data.repository.movies.datasource.MovieCacheDataSource
import com.example.myapplication.data.repository.movies.datasource.MovieLocalDataSource
import com.example.myapplication.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.myapplication.domain.Repository.MovieRepository

class MovieRepositoryImp(
    private val movieRemoteDataSource: MovieRemoteDataSource,
    private val movieCacheDataSource: MovieCacheDataSource,
    private val movieLocalDataSource: MovieLocalDataSource
) : MovieRepository {
    override suspend fun getMovies(): List<Movie> {
        return getMoviesFromCash()
    }

    override suspend fun updateMovies(): List<Movie> {
        val newMovieList = getMoviesFromApi()
        movieLocalDataSource.clearAll()
        movieLocalDataSource.saveMoviesToDataBase(newMovieList)
        movieCacheDataSource.saveMoviesToCash(newMovieList)
        return newMovieList
    }

    private suspend fun getMoviesFromApi(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            val response = movieRemoteDataSource.getMovies()
            val body = response.body()
            if (body != null) {
                movieList = body.movies
            }
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
        return movieList
    }

    private suspend fun getMoviesFromDataBase(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieLocalDataSource.getMoviesFromDataBase()!!
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromApi()
            movieLocalDataSource.saveMoviesToDataBase(movieList)
        }
        return movieList
    }

    private suspend fun getMoviesFromCash(): List<Movie> {
        lateinit var movieList: List<Movie>
        try {
            movieList = movieCacheDataSource.getMoviesFromCash()!!
        } catch (e: Exception) {
            println("Exception: ${e.message}")
        }
        if (movieList.isNotEmpty()) {
            return movieList
        } else {
            movieList = getMoviesFromDataBase()
            movieCacheDataSource.saveMoviesToCash(movieList)
        }
        return movieList
    }

}