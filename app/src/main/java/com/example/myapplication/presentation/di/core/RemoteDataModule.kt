package com.example.myapplication.presentation.di.core

import com.example.myapplication.data.api.TMDBService
import com.example.myapplication.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.myapplication.data.repository.artists.datasourceimp.ArtistRemoteDataSourceImp
import com.example.myapplication.data.repository.movies.datasource.MovieRemoteDataSource
import com.example.myapplication.data.repository.movies.datasourceimp.MovieRemoteDataSourceImp
import com.example.myapplication.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.myapplication.data.repository.tvshows.datasourceimp.TvShowRemoteDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule(
    private val apikey: String
) {
    @Provides
    @Singleton
    fun provideMovieRemoteDataSource(TMDBService: TMDBService): MovieRemoteDataSource {
        return MovieRemoteDataSourceImp(TMDBService, apikey)
    }

    fun provideArtistRemoteDataSource(TMDBService: TMDBService): ArtistRemoteDataSource {
        return ArtistRemoteDataSourceImp(TMDBService, apikey)
    }

    fun provideTvShowRemoteDataSource(TMDBService: TMDBService): TvShowRemoteDataSource {
        return TvShowRemoteDataSourceImp(TMDBService, apikey)
    }


}

