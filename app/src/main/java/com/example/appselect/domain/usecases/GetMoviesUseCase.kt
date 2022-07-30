package com.example.appselect.domain.usecases

import android.util.Log
import androidx.paging.PagingData
import androidx.paging.map
import com.example.appselect.domain.models.MovieDomain
import com.example.appselect.domain.repository.MovieRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect

interface GetMoviesUseCase {

    suspend fun getPangedMovie(): Flow<PagingData<MovieDomain>>
}

class GetMoviesUseCaseImpl(private val repository: MovieRepository) : GetMoviesUseCase {

    override suspend fun getPangedMovie(): Flow<PagingData<MovieDomain>> {
        return repository.getPagedMovies()
    }


}