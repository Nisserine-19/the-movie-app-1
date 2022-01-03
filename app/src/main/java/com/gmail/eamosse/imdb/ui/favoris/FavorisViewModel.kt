package com.gmail.eamosse.imdb.ui.favoris

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.Token
import com.gmail.eamosse.idbdata.local.entities.FavoriteEntity
// import com.gmail.eamosse.idbdata.local.entities.toDetailMovie
import com.gmail.eamosse.idbdata.repository.MovieRepository
import com.gmail.eamosse.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class FavorisViewModel(private val repository: MovieRepository) : ViewModel() {
    private val _token: MutableLiveData<Token> = MutableLiveData()
    val token: LiveData<Token>
        get() = _token

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    private val _favorites: MutableLiveData<List<FavoriteEntity>> = MutableLiveData()
    val favorites: LiveData<List<FavoriteEntity>>
        get() = _favorites

    init {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getToken()) {
                is Result.Succes -> {
                    _token.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }

    fun getFavorites() {
        viewModelScope.launch(Dispatchers.IO) {
            _favorites.postValue(repository.getFavoritesMovies())
        }
    }
}
