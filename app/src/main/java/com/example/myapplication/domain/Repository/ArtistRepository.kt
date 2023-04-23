package com.example.myapplication.domain.Repository

import com.example.myapplication.data.model.artist.Artist

interface ArtistRepository {
    suspend fun getArtists(): List<Artist>? // null if no artists are cached
    suspend fun updateArtists(): List<Artist>? // null if no artists are cached
}