package com.example.myapplication.presentation.di.artist

import com.example.myapplication.domain.UseCase.GetArtistUseCase
import com.example.myapplication.domain.UseCase.UpdateArtistUseCase
import com.example.myapplication.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {

    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistUseCase: GetArtistUseCase,
        updateArtistUseCase: UpdateArtistUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistUseCase,
            updateArtistUseCase
        )
    }
}