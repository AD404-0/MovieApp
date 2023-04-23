package com.example.myapplication.data.repository.tvshows.datasource

import com.example.myapplication.data.model.tvshow.TVShow

interface TvShowCacheDataSource {
    suspend fun getTvShowsFromCache(): List<TVShow>
    suspend fun saveTvShowsToCache(tvShows: List<TVShow>)
}