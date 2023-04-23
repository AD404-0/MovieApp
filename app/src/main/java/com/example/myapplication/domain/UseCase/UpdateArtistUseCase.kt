package com.example.myapplication.domain.UseCase

import com.example.myapplication.data.model.artist.Artist
import com.example.myapplication.domain.Repository.ArtistRepository

class UpdateArtistUseCase(private val artistRepository: ArtistRepository) {
    suspend operator fun invoke(): List<Artist>? = artistRepository.updateArtists()
}
