package com.example.myapplication.data.repository.artists.datasourceimp

import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.myapplication.data.repository.movies.datasource.MovieCacheDataSource
import com.example.myapplication.domain.Repository.ArtistRepository

class ArtistCacheDataSourceImp():ArtistCacheDataSource{
    private var artistList = ArrayList<Artist>()
    override suspend fun getArtistsFromCash(): List<Artist> {
        return artistList
    }

    override suspend fun saveArtistsToCash(artists: List<Artist>) {
        artistList.clear()
        artistList = ArrayList(artists)
    }


}