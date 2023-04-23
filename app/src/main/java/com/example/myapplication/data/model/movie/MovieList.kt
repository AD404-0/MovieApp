package com.example.myapplication.data.model.movie


import com.example.myapplication.data.model.movie.Movie
import com.google.gson.annotations.SerializedName

data class MovieList(

    @SerializedName("results")
    val movies: List<Movie>

)