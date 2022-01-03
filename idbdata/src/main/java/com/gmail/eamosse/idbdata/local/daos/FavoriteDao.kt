package com.gmail.eamosse.idbdata.local.daos

import androidx.room.*
import com.gmail.eamosse.idbdata.local.entities.FavoriteEntity

@Dao
interface FavoriteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addToFavorite(favoriteMovie: FavoriteEntity)

    @Query("SELECT * FROM favorite_movie")
    suspend fun getFavoriteMovie(): List<FavoriteEntity>

    @Query("SELECT count(*) FROM favorite_movie WHERE favorite_movie.id_movie = :id")
    suspend fun checkMovie(id: String): Int

    @Query("DELETE FROM favorite_movie WHERE favorite_movie.id_movie = :id")
    suspend fun removeFromFavorite(id: String): Int
}
