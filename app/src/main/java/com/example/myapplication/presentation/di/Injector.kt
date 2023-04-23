package com.example.myapplication.presentation.di

import com.example.myapplication.presentation.di.artist.ArtistSubComponent
import com.example.myapplication.presentation.di.movie.MovieSubComponent
import com.example.myapplication.presentation.di.tvshow.TvShowSubComponent

interface Injector {


    fun createMovieSubComponent(): MovieSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
}