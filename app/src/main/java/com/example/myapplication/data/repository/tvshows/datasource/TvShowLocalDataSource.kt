package com.example.myapplication.data.repository.tvshows.datasource

import com.example.myapplication.data.model.tvshow.TVShow

interface TvShowLocalDataSource {
    suspend fun getTvShowsFromDB(): List<TVShow>
    suspend fun saveTvShowsToDB(tvShows: List<TVShow>)
    suspend fun clearAll()
}