package com.gmail.eamosse.idbdata.datasources

import com.gmail.eamosse.idbdata.api.response.* // ktlint-disable no-wildcard-imports
import com.gmail.eamosse.idbdata.api.response.CategoryResponse
import com.gmail.eamosse.idbdata.api.response.TokenResponse
import com.gmail.eamosse.idbdata.api.response.parse
import com.gmail.eamosse.idbdata.api.response.safeCall
import com.gmail.eamosse.idbdata.api.service.MovieService
import com.gmail.eamosse.idbdata.utils.Result

/**
 * Manipule les données de l'application en utilisant un web service
 * Cette classe est interne au module, ne peut être initialisé ou exposé aux autres composants
 * de l'application
 */
internal class OnlineDataSource(private val service: MovieService) {

    /**
     * Récupérer le token du serveur
     * @return [Result<Token>]
     * Si [Result.Succes], tout s'est bien passé
     * Sinon, une erreur est survenue
     */

    suspend fun getToken(): Result<TokenResponse> {
        return safeCall {
            val response = service.getToken()
            response.parse()
        }
    }

    suspend fun getCategories(): Result<List<CategoryResponse.Genre>> {
        return try {
            val response = service.getCategories()
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.genres)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getMoviebyCategories(Id: String): Result<List<MoviesResponse.Movie>> {
        return try {
            val response = service.getMoviebyCategories(Id)
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.results)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getPopularMovies(): Result<List<PopularMoviesResponse.Movies>> {
        return try {
            val response = service.getPopularMovies()
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.movies)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getTopRatedMovies(): Result<List<PopularMoviesResponse.Movies>> {
        return try {
            val response = service.getTopRatedMovies()
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.movies)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getUpcomingMovies(): Result<List<PopularMoviesResponse.Movies>> {
        return try {
            val response = service.getUpcomingMovies()
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.movies)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getDetailMovie(Id: Int): Result<DetailResponse> {
        return try {
            val response = service.getDetailMovie(Id)
            if (response.isSuccessful) {
                Result.Succes(response.body()!!)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getSimilarMovies(Id: Int): Result<List<PopularMoviesResponse.Movies>> {
        return try {
            val response = service.getSimilarMovies(Id)
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.movies)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }

    suspend fun getVideo(Id: Int): Result<List<VideoResponse.Video>> {
        return try {
            val response = service.getVideo(Id)
            if (response.isSuccessful) {
                Result.Succes(response.body()!!.video)
            } else {
                Result.Error(
                    exception = Exception(),
                    message = response.message(),
                    code = response.code()
                )
            }
        } catch (e: Exception) {
            Result.Error(
                exception = e,
                message = e.message ?: "No message",
                code = -1
            )
        }
    }
}

