package com.example.myapplication.data.repository.artists.datasource

import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}