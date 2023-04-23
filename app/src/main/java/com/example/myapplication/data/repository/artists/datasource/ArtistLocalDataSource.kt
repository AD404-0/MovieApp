package com.example.myapplication.data.repository.artists.datasource

import com.example.myapplication.data.model.artist.Artist

interface ArtistLocalDataSource {
    suspend fun getArtistsFromDataBase(): List<Artist>?
    suspend fun saveArtistsToDataBase(artists: List<Artist>)
    suspend fun clearAll()
}