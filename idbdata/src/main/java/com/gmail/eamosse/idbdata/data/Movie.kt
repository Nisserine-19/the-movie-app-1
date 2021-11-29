package com.gmail.eamosse.idbdata.data

data class Movie(
    val poster_path: String,
    val overview: String,
    val release_date: String,
    val genre_ids: Int,
    val id: Int,
    val title: String,
    val backdrop_path: String?,
    val vote_average: Float
)
