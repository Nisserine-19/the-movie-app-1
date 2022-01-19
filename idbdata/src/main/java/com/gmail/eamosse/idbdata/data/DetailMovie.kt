package com.gmail.eamosse.idbdata.data

import com.gmail.eamosse.idbdata.api.response.DetailResponse

data class DetailMovie(
    val id: Int,
    val title: String,
    val overview: String?,
    val video: Boolean,
    val date: String,
    val poster_path: String,
    val backdrop_path: String?,
    val vote_average: Number,
    val runtime: Int?,
    val original_language: String,
    var production_companies: List<DetailResponse.Company>
)
