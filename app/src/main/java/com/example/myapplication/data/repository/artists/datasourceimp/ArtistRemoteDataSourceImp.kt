package com.example.myapplication.data.repository.artists.datasourceimp

import com.example.myapplication.data.api.TMDBService
import com.example.myapplication.data.model.artist.ArtistList
import com.example.myapplication.data.repository.artists.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImp(
    private val tmbdService: TMDBService,
    private val apikey: String
) : ArtistRemoteDataSource {
    override suspend fun getArtists(): Response<ArtistList> {
        return tmbdService.getPopularPeople(apikey)
    }

}

