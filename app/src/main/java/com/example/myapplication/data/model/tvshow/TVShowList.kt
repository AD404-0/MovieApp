package com.example.myapplication.data.model.tvshow


import com.example.myapplication.data.model.tvshow.TVShow
import com.google.gson.annotations.SerializedName

data class TVShowList(

    @SerializedName("results")
    val TVShows: List<TVShow>

)