package com.example.myapplication.data.repository.artists.datasourceimp

import com.example.myapplication.data.db.ArtistDao
import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.data.repository.artists.datasource.ArtistLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ArtistLocalDataSourceImp(
    private val artistDao: ArtistDao
) : ArtistLocalDataSource {
    override suspend fun getArtistsFromDataBase(): List<Artist>? {
        return artistDao.getArtists()
    }

    override suspend fun saveArtistsToDataBase(artists: List<Artist>) {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.saveArtist(artists)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            artistDao.deleteAllArtists()
        }

    }
}