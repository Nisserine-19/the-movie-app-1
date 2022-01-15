package com.gmail.eamosse.idbdata.api.response

// import com.gmail.eamosse.idbdata.data.Category
// import com.gmail.eamosse.idbdata.data.Movie
import com.gmail.eamosse.idbdata.data.Movie
import com.google.gson.annotations.SerializedName

data class MoviesResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<Movie>
) {
    data class Movie(
        @SerializedName("id")
        var id: Int,

        @SerializedName("poster_path")
        var posterPath: String,

        @SerializedName("backdrop_path")
        var backdropPath: String?,

        @SerializedName("title")
        var title: String,
        @SerializedName("video")
        val video: Boolean,
        @SerializedName("release_date")
        var releaseDate: String,
        @SerializedName("overview")
        var overview: String?
    )
}

internal fun MoviesResponse.Movie.toMovie() = Movie(
    id = id,
    posterPath = posterPath,
    backdropPath = backdropPath,
    title = title,
    video = video,
    releaseDate = releaseDate,
    overview = overview
)
