package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.DetailMovie
import com.google.gson.annotations.SerializedName

data class DetailResponse(
    @SerializedName("id")
    val id: Int,
    @SerializedName("runtime")
    val runtime: Int,
    @SerializedName("title")
    val title: String,
    @SerializedName("overview")
    val overview: String,
    @SerializedName("video")
    val video: Boolean,
    @SerializedName("release_date")
    val date: String,
    @SerializedName("poster_path")
    val poster_path: String,
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("vote_average")
    val vote_average: Number,
    @SerializedName("production_companies")
    val production_companies: List<Company>,
    @SerializedName("original_language")
    val original_language: String,
) {
    data class Company(
        @SerializedName("id") val id: Int,
        @SerializedName("name") val name: String,
        @SerializedName("origin_country") val originCountry: String,
        @SerializedName("logo_path") val logoPath: String
    )
}

internal fun DetailResponse.toDetailMovie() = DetailMovie(
    id = id,
    title = title,
    overview = overview,
    video = video,
    date = date,
    poster_path = poster_path,
    backdrop_path = backdrop_path,
    vote_average = vote_average,
    production_companies = production_companies,
    runtime = runtime,
    original_language = original_language


)
