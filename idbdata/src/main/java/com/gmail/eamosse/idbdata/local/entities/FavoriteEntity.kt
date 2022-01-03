package com.gmail.eamosse.idbdata.local.entities

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.io.Serializable

@Entity(tableName = "favorite_movie")
@Parcelize
data class FavoriteEntity(
    val id_movie: String,
    val backdroppath: String?,
    val original_title: String,
    val overview: String?,
    val poster_path: String,
    val video: Boolean,
    val release_date: String,
) : Serializable, Parcelable {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    val baseUrl get() = "https://image.tmdb.org/t/p/w500"
}

// fun FavoriteEntity.toDetailMovie() = DetailMovie(
//    id = id_movie.toInt(),
//    title = original_title,
//    backdrop_path = backdroppath,
//    date = release_date,
//    overview = overview,
//    video = video,
//    poster_path = poster_path,
// )

// fun FavoriteEntity.toMovie() = Movie(
//    id = id_movie.toInt(),
//    posterPath = poster_path,
//    backdropPath = backdroppath,
//    title = title,
//    voteAverage = vote_average.toFloat(),
//    releaseDate = release_date,
//    overview = overview
// )
