package com.example.myapplication.data.repository.tvshows.datasourceimp

import com.example.myapplication.data.api.TMDBService
import com.example.myapplication.data.model.tvshow.TVShowList
import com.example.myapplication.data.repository.tvshows.datasource.TvShowRemoteDataSource
import retrofit2.Response

class TvShowRemoteDataSourceImp(
    private val tmdbService: TMDBService,
    private val apiKey: String
) : TvShowRemoteDataSource {
    override suspend fun getTvShows(): Response<TVShowList> {
        return tmdbService.getPopularTVShows(apiKey)
    }
}