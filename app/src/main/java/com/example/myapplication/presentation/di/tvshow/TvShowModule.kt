package com.example.myapplication.presentation.di.tvshow

import com.example.myapplication.domain.UseCase.GetTvShowsUseCase
import com.example.myapplication.domain.UseCase.UpdateTvShowsUseCase
import com.example.myapplication.presentation.tvShow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }
}