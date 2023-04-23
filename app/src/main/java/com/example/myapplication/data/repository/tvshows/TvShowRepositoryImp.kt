package com.example.myapplication.data.repository.tvshows

import com.example.myapplication.data.model.tvshow.TVShow
import com.example.myapplication.data.repository.tvshows.datasource.TvShowCacheDataSource
import com.example.myapplication.data.repository.tvshows.datasource.TvShowLocalDataSource
import com.example.myapplication.data.repository.tvshows.datasource.TvShowRemoteDataSource
import com.example.myapplication.domain.Repository.TvShowsRepository

class TvShowRepositoryImp
    (
    private val tvShowCacheDataSource: TvShowCacheDataSource,
    private val tvShowLocalDataSource: TvShowLocalDataSource,
    private val tvShowRemoteDataSource: TvShowRemoteDataSource
): TvShowsRepository {
    override suspend fun getTvShow(): List<TVShow>? {
        return getTvShowsFromCash()
    }

    override suspend fun updateTvShows(): List<TVShow>? {
        val newListOfTvShows = getTvShowsFromApi()
        tvShowLocalDataSource.clearAll()
        tvShowLocalDataSource.saveTvShowsToDB(newListOfTvShows)
        tvShowCacheDataSource.saveTvShowsToCache(newListOfTvShows)
        return newListOfTvShows
    }

    private suspend fun getTvShowsFromApi(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            val response = tvShowRemoteDataSource.getTvShows()
            val body = response.body()
            if (body != null) {
                tvShowList = body.TVShows
            }
        } catch (exception: Exception) {
            println(exception.message.toString())
        }
        return tvShowList
    }
    private suspend fun getTvShowsFromDataBase(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowLocalDataSource.getTvShowsFromDB()
        } catch (exception: Exception) {
            println(exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromApi()
            tvShowLocalDataSource.saveTvShowsToDB(tvShowList)
        }
        return tvShowList
    }

    private suspend fun getTvShowsFromCash(): List<TVShow> {
        lateinit var tvShowList: List<TVShow>
        try {
            tvShowList = tvShowCacheDataSource.getTvShowsFromCache()
        } catch (exception: Exception) {
            println(exception.message.toString())
        }
        if (tvShowList.isNotEmpty()) {
            return tvShowList
        } else {
            tvShowList = getTvShowsFromDataBase()
            tvShowCacheDataSource.saveTvShowsToCache(tvShowList)
        }
        return tvShowList
    }
}