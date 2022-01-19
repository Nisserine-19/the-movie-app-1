package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Companie
import com.gmail.eamosse.idbdata.data.DetailMovie
import com.google.gson.annotations.SerializedName

internal data class DetailResponse(
    @SerializedName("id")
    val id: Int,
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
//    @SerializedName("production_companies")
//    val companies: List<Companie>
) {
    data class Companie(
        @SerializedName("id")
        val idComp: Long,
        @SerializedName("name")
        val name: String
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
    vote_average = vote_average
)

//internal fun DetailResponse.Companie.toDetailMovie() = Companie(
//    idComp = idComp,
//    name = name
//)
