package com.example.myapplication.presentation.movie

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.UseCase.GetMoviesUseCase
import com.example.myapplication.domain.UseCase.UpdateMoviesUseCase

class MovieViewModelFactory(
    private val getMovieUseCase: GetMoviesUseCase,
    private val updateMoviesUseCase: UpdateMoviesUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return MovieViewModel(getMovieUseCase, updateMoviesUseCase) as T
    }
}



