package com.example.myapplication.data.repository.tvshows.datasource

import com.example.myapplication.data.model.tvshow.TVShowList
import retrofit2.Response

interface TvShowRemoteDataSource {
    suspend fun getTvShows(): Response<TVShowList>
}