package com.example.myapplication.presentation.di.core

import android.app.Activity
import com.example.myapplication.presentation.di.artist.ArtistSubComponent
import com.example.myapplication.presentation.di.movie.MovieSubComponent
import com.example.myapplication.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component
    (modules =
    [
        AppModule::class,
        NetModule::class,
        UseCaseModule::class,
        CacheDataModule::class,
        RemoteDataModule::class,
        LocalDataModule::class,
        RepositoryModule::class,
        RemoteDataModule::class,
    ])


interface AppComponent {
    fun inject(appComponent: AppComponent)
    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory

}