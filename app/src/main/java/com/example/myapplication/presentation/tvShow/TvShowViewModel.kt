package com.example.myapplication.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.domain.UseCase.GetTvShowsUseCase
import com.example.myapplication.domain.UseCase.UpdateTvShowsUseCase

class TvShowViewModel(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowsUseCase
): ViewModel() {
    fun getTvShows() = liveData {
        val tvShowList = getTvShowUseCase.invoke()
        emit(tvShowList)
    }

    fun updateTvShows() = liveData {
        val tvShowList = updateTvShowUseCase.invoke()
        emit(tvShowList)
    }
}