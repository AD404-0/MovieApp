package com.example.myapplication.domain.Repository

import com.example.myapplication.data.model.tvshow.TVShow

interface TvShowsRepository {
    suspend fun getTvShow(): List<TVShow>? // null if no tv shows are cached
    suspend fun updateTvShows(): List<TVShow>? // null if no tv shows are cached

}