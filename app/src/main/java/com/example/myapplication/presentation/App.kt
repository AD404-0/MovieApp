package com.example.myapplication.presentation

import android.app.Application
import com.example.myapplication.BuildConfig
import com.example.myapplication.presentation.di.Injector

import com.example.myapplication.presentation.di.artist.ArtistSubComponent
import com.example.myapplication.presentation.di.core.AppComponent
import com.example.myapplication.presentation.di.core.AppModule
import com.example.myapplication.presentation.di.core.NetModule
import com.example.myapplication.presentation.di.core.RemoteDataModule
import com.example.myapplication.presentation.di.movie.MovieSubComponent
import com.example.myapplication.presentation.di.tvshow.TvShowSubComponent


class App : Application(), Injector {
     private lateinit var appComponent: AppComponent
    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()
    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }
}









