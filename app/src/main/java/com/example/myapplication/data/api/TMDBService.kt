package com.example.myapplication.data.api

import com.example.myapplication.data.model.artist.ArtistList
import com.example.myapplication.data.model.movie.MovieList
import com.example.myapplication.data.model.tvshow.TVShowList
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface TMDBService {
    @GET("movie/popular")
    suspend fun getPopularMovies(@Query("api_key") apiKey: String): Response<MovieList>

    @GET("tv/popular")
    suspend fun getPopularTVShows(@Query("api_key") apiKey: String): Response<TVShowList>

    @GET("person/popular")
    suspend fun getPopularPeople(@Query("api_key") apiKey: String): Response<ArtistList>


}