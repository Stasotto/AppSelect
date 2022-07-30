package com.example.appselect.domain.repository

import androidx.paging.PagingData
import com.example.appselect.domain.models.MovieDomain
import kotlinx.coroutines.flow.Flow

interface MovieRepository {

    suspend fun getPagedMovies(): Flow<PagingData<MovieDomain>>
}