package com.example.myapplication.presentation.di.core

import com.example.myapplication.data.repository.artists.ArtistRepositoryImp
import com.example.myapplication.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.myapplication.data.repository.movies.MovieRepositoryImp
import com.example.myapplication.data.repository.movies.datasource.MovieCacheDataSource
import com.example.myapplication.data.repository.movies.datasource.MovieLocalDataSource
import com.example.myapplication.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.myapplication.data.repository.tvshows.TvShowRepositoryImp
import com.example.myapplication.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.myapplication.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.example.myapplication.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.myapplication.domain.Repository.ArtistRepository
import com.example.myapplication.domain.Repository.MovieRepository
import com.example.myapplication.domain.Repository.TvShowsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class RepositoryModule {

    @Singleton
    @Provides
    fun provideMovieRepository(
        movieRemoteDataSource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {
        return MovieRepositoryImp(
            movieRemoteDataSource,
            movieCacheDataSource,
            movieLocalDataSource
        )
    }

    @Singleton
    @Provides
    fun provideArtistRepository(
        artistRemoteDataSource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {
        return ArtistRepositoryImp(
            artistLocalDataSource,
            artistRemoteDataSource,
            artistCacheDataSource
        )
    }


    @Singleton
    @Provides
    fun provideTvShowRepository(
        tvShowRemoteDataSource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowsRepository {
        return TvShowRepositoryImp(
            tvShowCacheDataSource,
            tvShowLocalDataSource,
            tvShowRemoteDataSource
        )
    }


}