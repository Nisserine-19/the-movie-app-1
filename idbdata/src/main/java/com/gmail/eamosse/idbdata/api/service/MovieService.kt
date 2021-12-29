package com.gmail.eamosse.idbdata.api.service

import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.MoviesResponse
import com.gmail.eamosse.idbdata.api.response.PopularMoviesResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

internal interface MovieService {
    @GET("authentication/token/new")
    suspend fun getToken(): Response<TokenResponse>

    @GET("genre/movie/list")
    suspend fun getCategories(): Response<CategoryResponse>

    // ajouter
    @GET("discover/movie")
    suspend fun getMoviebyCategories(@Query("with_genres") Id: String): Response<MoviesResponse>

    @GET("movie/popular")
    suspend fun getPopularMovies(): Response<PopularMoviesResponse>
//    suspend fun getPopularMovies(@Query("page") page: Int): Response<PopularMoviesResponse>
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<PopularMoviesResponse>
}
