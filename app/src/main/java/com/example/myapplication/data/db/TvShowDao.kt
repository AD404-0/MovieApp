package com.example.myapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.tvshow.TVShow
import com.example.myapplication.data.model.tvshow.TVShowList
@Dao
interface TvShowDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveTvShow(tvShows: List<TVShow>)

    @Query("DELETE FROM tvshow")
    suspend fun deleteAllTvShows()

    @Query("SELECT * FROM tvshow")
    suspend fun getTvShows(): List<TVShow>

}