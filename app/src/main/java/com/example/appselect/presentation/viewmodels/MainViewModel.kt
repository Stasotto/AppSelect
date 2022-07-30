package com.example.appselect.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagingData
import androidx.paging.map
import com.example.appselect.domain.usecases.GetMoviesUseCase
import com.example.appselect.presentation.models.Movie
import com.example.appselect.presentation.toMovie
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

@FlowPreview
@ExperimentalCoroutinesApi
class MainViewModel(
    private val getMoviesUseCase: GetMoviesUseCase
) : ViewModel() {

    val moviesFlow: Flow<PagingData<Movie>>

    init {
        moviesFlow = flow {
            getMoviesUseCase.getPangedMovie().collect {
                emit(it.map { movieDomain ->
                    movieDomain.toMovie()
                }
                )
            }
        }
    }

    class Factory @Inject constructor(
        private val getMoviesUseCase: GetMoviesUseCase
    ) :
        ViewModelProvider.Factory {
        @Suppress("UNCHECKED_CAST")
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MainViewModel(getMoviesUseCase) as T
        }
    }
}