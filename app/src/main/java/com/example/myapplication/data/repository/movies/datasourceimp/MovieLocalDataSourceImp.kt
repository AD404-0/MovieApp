package com.example.myapplication.data.repository.movies.datasourceimp

import com.example.myapplication.data.db.MovieDao
import com.example.myapplication.data.model.movie.Movie
import com.example.myapplication.data.repository.movies.datasource.MovieLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MovieLocalDataSourceImp(private val movieDao: MovieDao): MovieLocalDataSource {
    override suspend fun getMoviesFromDataBase(): List<Movie> {
        return movieDao.getMovies()
    }

    override suspend fun saveMoviesToDataBase(movies: List<Movie>) {
       CoroutineScope(Dispatchers.IO).launch {
           movieDao.saveMovie(movies)
       }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            movieDao.deleteAllMovies()
        }
    }
}