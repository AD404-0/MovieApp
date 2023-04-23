package com.example.myapplication.domain.UseCase

import com.example.myapplication.data.model.movie.Movie
import com.example.myapplication.domain.Repository.MovieRepository

class GetMoviesUseCase (private val movieRepository: MovieRepository) {
    suspend operator fun invoke(): List<Movie>? = movieRepository.getMovies()


}