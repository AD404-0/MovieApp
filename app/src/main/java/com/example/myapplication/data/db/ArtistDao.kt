package com.example.myapplication.data.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.model.artist.ArtistList
@Dao
interface ArtistDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveArtist(artists: List<Artist>)

    @Query("DELETE FROM artists")
    suspend fun deleteAllArtists()

    @Query("SELECT * FROM artists")
    suspend fun getArtists(): List<Artist>

}