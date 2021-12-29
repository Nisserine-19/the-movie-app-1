package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.PopularMovies
import com.google.gson.annotations.SerializedName

data class PopularMoviesResponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movies>,
    @SerializedName("total_pages") val pages: Int
) {
    data class Movies(
        @SerializedName("id") val id: Long,
        @SerializedName("title") val title: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("vote_average") val voteAverage: Float,
        @SerializedName("release_date") val releaseDate: String
    )
}

internal fun PopularMoviesResponse.Movies.toPopularMovies() = PopularMovies(
    id = id,
    title = title,
    overview = overview,
    posterPath = posterPath,
    backdropPath = backdropPath,
    voteAverage = voteAverage,
    releaseDate = releaseDate
)
