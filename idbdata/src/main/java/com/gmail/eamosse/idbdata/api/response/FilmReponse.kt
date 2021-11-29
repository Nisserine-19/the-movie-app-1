package com.gmail.eamosse.idbdata.api.response

import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

// //ajouter
data class FilmReponse(
    @SerializedName("page") val page: Int,
    @SerializedName("results") val movies: List<Movie>,
    @SerializedName("total_results") val totalResults: Int,
    @SerializedName("total_pages") val totalPages: Int
) {
    data class Movie(
        @SerializedName("poster_path") val posterPath: String,
        @SerializedName("overview") val overview: String,
        @SerializedName("release_date") val releaseDate: String,
        @SerializedName("genre_ids") val genreIds: Int,
        @SerializedName("id") val id: Int,
        @SerializedName("title") val title: String,
        @SerializedName("backdrop_path") val backdropPath: String,
        @SerializedName("vote_average") val voteAverage: Float,
    )
}
internal fun FilmReponse.Movie.toMovie() = Movie(
    poster_path = posterPath,
    overview = overview,
    release_date = releaseDate,
    genre_ids = genreIds,
    id = id,
    title = title,
    backdrop_path = backdropPath,
    vote_average = voteAverage
)
