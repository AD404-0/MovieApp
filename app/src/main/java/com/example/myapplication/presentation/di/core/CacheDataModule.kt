package com.example.myapplication.presentation.di.core

import com.example.myapplication.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.myapplication.data.repository.artists.datasourceimp.ArtistCacheDataSourceImp
import com.example.myapplication.data.repository.movies.datasource.MovieCacheDataSource
import com.example.myapplication.data.repository.movies.datasourceimp.MovieCacheDataSourceImp
import com.example.myapplication.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.myapplication.data.repository.tvshows.datasourceimp.TvShowCacheDataSourceImp
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImp()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImp()
    }
}