package com.example.appselect.data.storage.retrofit

import com.example.appselect.data.models.MovieResponse
import com.example.appselect.data.storage.NetworkStorage

class NetworkStorageImpl(private val api: MoviesApi) : NetworkStorage {

    override suspend fun getMovies(offset: Int): MovieResponse {
        return api.getMovies(offset = offset)
    }

}