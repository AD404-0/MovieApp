package com.example.myapplication.presentation.movie


import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.domain.UseCase.GetMoviesUseCase
import com.example.myapplication.domain.UseCase.UpdateMoviesUseCase

class MovieViewModel(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModel() {


    fun getMovies() = liveData{
        val movieList = getMovieUseCase.invoke()
        emit(movieList)
    }

    fun updateMovies() = liveData{
        val movieList = updateMoviesUseCase.invoke()
        emit(movieList)
    }


}