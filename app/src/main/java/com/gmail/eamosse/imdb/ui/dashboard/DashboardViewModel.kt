package com.gmail.eamosse.imdb.ui.dashboard

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmail.eamosse.idbdata.data.PopularMovies
import com.gmail.eamosse.idbdata.repository.MovieRepository
import com.gmail.eamosse.idbdata.utils.Result
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class DashboardViewModel(private val repository: MovieRepository) : ViewModel() {

    private val _popularmovies: MutableLiveData<List<PopularMovies>> = MutableLiveData()
    val popularmovies: LiveData<List<PopularMovies>>
        get() = _popularmovies

    private val _error: MutableLiveData<String> = MutableLiveData()
    val error: LiveData<String>
        get() = _error

    fun getPopularMovies(page: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            when (val result = repository.getPopularMovies(page)) {
                is Result.Succes -> {
                    _popularmovies.postValue(result.data)
                }
                is Result.Error -> {
                    _error.postValue(result.message)
                }
            }
        }
    }
}
