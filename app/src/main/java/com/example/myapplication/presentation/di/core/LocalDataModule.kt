package com.example.myapplication.presentation.di.core

import com.example.myapplication.data.db.ArtistDao
import com.example.myapplication.data.db.MovieDao
import com.example.myapplication.data.db.TvShowDao
import com.example.myapplication.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.myapplication.data.repository.artists.datasourceimp.ArtistLocalDataSourceImp
import com.example.myapplication.data.repository.movies.datasource.MovieLocalDataSource
import com.example.myapplication.data.repository.movies.datasourceimp.MovieLocalDataSourceImp
import com.example.myapplication.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.example.myapplication.data.repository.tvshows.datasourceimp.TvShowLocalDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {
    @Provides
    @Singleton
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImp(movieDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao: ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImp(artistDao)
    }

    @Provides
    @Singleton
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImp(tvShowDao)
    }


}