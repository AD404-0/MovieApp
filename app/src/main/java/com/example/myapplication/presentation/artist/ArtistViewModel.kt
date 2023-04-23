package com.example.myapplication.presentation.artist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.myapplication.domain.UseCase.GetArtistUseCase
import com.example.myapplication.domain.UseCase.UpdateArtistUseCase

class ArtistViewModel(
    private val getArtistUseCase: GetArtistUseCase,
    private val updateArtistUseCase: UpdateArtistUseCase
):ViewModel() {
    fun getArtist() = liveData {
        val artistList = getArtistUseCase.invoke()
        emit(artistList)
    }

    fun updateArtist() = liveData {
        val artistList = updateArtistUseCase.invoke()
        emit(artistList)
    }
}