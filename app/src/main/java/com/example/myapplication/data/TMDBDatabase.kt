package com.example.myapplication.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.myapplication.data.db.ArtistDao
import com.example.myapplication.data.db.MovieDao
import com.example.myapplication.data.db.TvShowDao
import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.model.movie.Movie
import com.example.myapplication.data.model.tvshow.TVShow

@Database(entities = [Movie::class, TVShow::class, Artist::class], version = 1, exportSchema = false)
abstract class TMDBDatabase: RoomDatabase() {
    abstract fun movieDao(): MovieDao
    abstract fun tvShowDao(): TvShowDao
    abstract fun artistDao(): ArtistDao

}