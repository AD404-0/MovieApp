package com.example.myapplication.presentation.di.core

import android.content.Context
import androidx.room.Room
import com.example.myapplication.data.TMDBDatabase
import com.example.myapplication.data.db.ArtistDao
import com.example.myapplication.data.db.MovieDao
import com.example.myapplication.data.db.TvShowDao
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DataBaseModule {
    @Singleton // only one instance of the database
    @Provides // provides the database
    fun provideDataBase(context: Context): TMDBDatabase {
        return Room.databaseBuilder(
            context,
            TMDBDatabase::class.java,
            "TMDBClient.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideMovieDao (TMDBDatabase: TMDBDatabase): MovieDao {
        return TMDBDatabase.movieDao()
    }
    @Singleton
    @Provides
    fun provideArtistDao (TMDBDatabase: TMDBDatabase): ArtistDao {
        return TMDBDatabase.artistDao()
    }
    @Provides
    @Singleton
    fun provideTvShow (TMDBDatabase: TMDBDatabase): TvShowDao {
        return TMDBDatabase.tvShowDao()
    }
}