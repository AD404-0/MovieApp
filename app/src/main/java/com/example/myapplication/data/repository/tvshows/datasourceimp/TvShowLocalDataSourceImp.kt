package com.example.myapplication.data.repository.tvshows.datasourceimp

import com.example.myapplication.data.db.TvShowDao
import com.example.myapplication.data.model.tvshow.TVShow
import com.example.myapplication.data.repository.tvshows.datasource.TvShowLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class TvShowLocalDataSourceImp(
    private val tvShowDao: TvShowDao
) : TvShowLocalDataSource {
    override suspend fun getTvShowsFromDB(): List<TVShow> {
        return tvShowDao.getTvShows()
    }

    override suspend fun saveTvShowsToDB(tvShows: List<TVShow>) {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.saveTvShow(tvShows)
        }
    }

    override suspend fun clearAll() {
        CoroutineScope(Dispatchers.IO).launch {
            tvShowDao.deleteAllTvShows()
        }
    }
}
