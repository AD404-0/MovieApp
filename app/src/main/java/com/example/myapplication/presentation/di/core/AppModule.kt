package com.example.myapplication.presentation.di.core

import android.content.Context
import com.example.myapplication.presentation.di.artist.ArtistSubComponent
import com.example.myapplication.presentation.di.movie.MovieSubComponent
import com.example.myapplication.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton



@Module(subcomponents = [MovieSubComponent::class, TvShowSubComponent::class, ArtistSubComponent::class])
class AppModule(private val context: Context) {
    @Provides
    @Singleton
    fun provideContext(): Context {
        return context
    }


}