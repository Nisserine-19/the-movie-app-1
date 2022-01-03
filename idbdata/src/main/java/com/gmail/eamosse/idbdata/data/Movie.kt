package com.gmail.eamosse.idbdata.data

// import com.gmail.eamosse.idbdata.api.response.MovieByCategorieResponse
// import com.google.gson.annotations.SerializedName

data class Movie(
    var id: Int,
    var posterPath: String,
    var backdropPath: String ?,
    val video: Boolean,
    var title: String,
    var releaseDate: String,
    var overview: String?
)
