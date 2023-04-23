package com.example.myapplication.presentation.tvShow

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.domain.UseCase.GetTvShowsUseCase
import com.example.myapplication.domain.UseCase.UpdateTvShowsUseCase

class TvShowViewModelFactory(
    private val getTvShowUseCase: GetTvShowsUseCase,
    private val updateTvShowUseCase: UpdateTvShowsUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TvShowViewModel(getTvShowUseCase, updateTvShowUseCase) as T
    }

}