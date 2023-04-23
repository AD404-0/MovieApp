package com.example.myapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.movie.Movie
import dagger.Provides

@Dao
interface MovieDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveMovie(movies: List<Movie>)

    @Query("DELETE FROM movie")
    suspend fun deleteAllMovies()

    @Query("SELECT * FROM movie")
    suspend fun getMovies(): List<Movie>


}
