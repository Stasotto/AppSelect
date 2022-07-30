package com.example.appselect.data

import android.util.Log
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.example.appselect.data.storage.NetworkStorage
import com.example.appselect.domain.models.MovieDomain
import com.example.appselect.domain.repository.MovieRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext

class MovieRepositoryImpl(private val network: NetworkStorage) : MovieRepository {

    private companion object {
        const val PAGE_SIZE = 20
    }

    override suspend fun getPagedMovies(): Flow<PagingData<MovieDomain>> {
        Log.d("Debug", "start loading")
        val loader: MoviePageLoader = { offset ->
            withContext(Dispatchers.IO) {
                Log.d("Debug", network.getMovies(offset).toString())
                network.getMovies(offset)
            }
        }
        return Pager(
            config = PagingConfig(
                pageSize = PAGE_SIZE,
                enablePlaceholders = false,
                initialLoadSize = PAGE_SIZE
            ),
            pagingSourceFactory = {
                MoviesPagingSource(loader = loader)
            }
        ).flow
    }
}