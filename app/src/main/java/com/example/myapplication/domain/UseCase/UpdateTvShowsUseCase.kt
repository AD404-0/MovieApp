package com.example.myapplication.domain.UseCase

import com.example.myapplication.data.model.tvshow.TVShow
import com.example.myapplication.domain.Repository.TvShowsRepository

class UpdateTvShowsUseCase(private val tvShowRepository: TvShowsRepository) {
    suspend operator fun invoke(): List<TVShow>? = tvShowRepository.updateTvShows()
}
