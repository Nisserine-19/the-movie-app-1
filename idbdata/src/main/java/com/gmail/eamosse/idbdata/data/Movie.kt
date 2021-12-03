package com.gmail.eamosse.idbdata.data

// import com.gmail.eamosse.idbdata.api.response.MovieByCategorieResponse
// import com.google.gson.annotations.SerializedName

data class Movie(
    var id: Int,
    var posterPath: String,
    var backdropPath: String,
    var title: String,
    var voteCount: Int,
    var voteAverage: Float,
    var genreIds: List<Int>,
    var originalLanguage: String = "",
    var releaseDate: String?,
    var runtime: Int?,
    var overview: String?
)
