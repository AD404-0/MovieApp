package com.example.myapplication.presentation.di.movie

import com.example.myapplication.domain.UseCase.GetMoviesUseCase
import com.example.myapplication.domain.UseCase.UpdateMoviesUseCase
import com.example.myapplication.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class MovieModule {
    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUseCase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUseCase
        )
    }

}