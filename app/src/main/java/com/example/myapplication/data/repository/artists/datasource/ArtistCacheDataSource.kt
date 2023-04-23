package com.example.myapplication.data.repository.artists.datasource

import com.example.myapplication.data.model.artist.Artist

interface ArtistCacheDataSource {
    suspend fun getArtistsFromCash(): List<Artist>
    suspend fun saveArtistsToCash(artists: List<Artist>)
}