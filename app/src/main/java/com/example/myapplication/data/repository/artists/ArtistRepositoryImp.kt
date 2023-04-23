package com.example.myapplication.data.repository.artists

import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.repository.artists.datasource.ArtistCacheDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistLocalDataSource
import com.example.myapplication.data.repository.artists.datasource.ArtistRemoteDataSource
import com.example.myapplication.domain.Repository.ArtistRepository

class ArtistRepositoryImp(
    private val artistLocalDataSource: ArtistLocalDataSource,
    private val artistRemoteDataSource: ArtistRemoteDataSource,
    private val artistCacheDataSource: ArtistCacheDataSource
) : ArtistRepository {
    override suspend fun getArtists(): List<Artist>? {
        return getArtistFromCash()
    }

    override suspend fun updateArtists(): List<Artist>? {
        val newListOfArtists = getArtistFromApi()
        artistLocalDataSource.clearAll()
        artistLocalDataSource.saveArtistsToDataBase(newListOfArtists!!)
        artistCacheDataSource.saveArtistsToCash(newListOfArtists)
        return newListOfArtists
    }

    private suspend fun getArtistFromApi(): List<Artist>? {
        lateinit var artistList: List<Artist>
        try {
            val response = artistRemoteDataSource.getArtists()
            val body = response.body()
            if (body != null) {
                artistList = body.artists
            }
        } catch (e: Exception) {
            println(e.message)
        }
        return artistList

    }

    private suspend fun getArtistFromDataBase(): List<Artist>? {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistLocalDataSource.getArtistsFromDataBase()!!
        } catch (e: Exception) {
            println(e.message)
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromApi()!!
            artistLocalDataSource.saveArtistsToDataBase(artistList)
        }
        return artistList
    }

    private suspend fun getArtistFromCash(): List<Artist>? {
        lateinit var artistList: List<Artist>
        try {
            artistList = artistCacheDataSource.getArtistsFromCash()
        } catch (e: Exception) {
            println(e.message)
        }
        if (artistList.isNotEmpty()) {
            return artistList
        } else {
            artistList = getArtistFromDataBase()!!
            artistCacheDataSource.saveArtistsToCash(artistList)
        }
        return artistList
    }
}