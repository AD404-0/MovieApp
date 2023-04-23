package com.example.myapplication.presentation.di.core

import com.example.myapplication.domain.Repository.ArtistRepository
import com.example.myapplication.domain.Repository.MovieRepository
import com.example.myapplication.domain.Repository.TvShowsRepository
import com.example.myapplication.domain.UseCase.GetArtistUseCase
import com.example.myapplication.domain.UseCase.GetMoviesUseCase
import com.example.myapplication.domain.UseCase.GetTvShowsUseCase
import com.example.myapplication.domain.UseCase.UpdateArtistUseCase
import com.example.myapplication.domain.UseCase.UpdateMoviesUseCase
import com.example.myapplication.domain.UseCase.UpdateTvShowsUseCase
import dagger.Module
import dagger.Provides
@Module
class UseCaseModule {

    @Provides
    fun provideGetMoviesUseCaseModule(movieRepository: MovieRepository): GetMoviesUseCase {
        return GetMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideUpdateMoviesUseCaseModule(movieRepository: MovieRepository): UpdateMoviesUseCase {
        return UpdateMoviesUseCase(movieRepository)
    }

    @Provides
    fun provideGetArtistsUseCaseModule(artistRepository: ArtistRepository): GetArtistUseCase {
        return GetArtistUseCase(artistRepository)
    }

    @Provides
    fun provideUpdateArtistsUseCaseModule(artistRepository: ArtistRepository): UpdateArtistUseCase {
        return UpdateArtistUseCase(artistRepository)
    }

    @Provides
    fun provideGetTvShowsUseCaseModule(tvShowRepository: TvShowsRepository): GetTvShowsUseCase {
        return GetTvShowsUseCase(tvShowRepository)
    }

    @Provides
    fun provideUpdateTvShowsUseCaseModule(tvShowRepository: TvShowsRepository): UpdateTvShowsUseCase {
        return UpdateTvShowsUseCase(tvShowRepository)
    }


}