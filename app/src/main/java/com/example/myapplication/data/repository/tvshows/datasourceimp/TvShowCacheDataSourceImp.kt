package com.example.myapplication.data.repository.tvshows.datasourceimp

import com.example.myapplication.data.model.tvshow.TVShow
import com.example.myapplication.data.repository.tvshows.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImp: TvShowCacheDataSource {
    private var tvShowList = ArrayList<TVShow>()
    override suspend fun getTvShowsFromCache(): List<TVShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TVShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}


