package com.gmail.eamosse.idbdata.data

data class DetailMovie(
    val id: Int,
    val title: String,
    val overview: String?,
    val video: Boolean,
    val date: String,
    val poster_path: String,
    val backdrop_path: String?,
    val vote_average: Number
)
