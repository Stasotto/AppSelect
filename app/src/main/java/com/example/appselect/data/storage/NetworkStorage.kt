package com.example.appselect.data.storage

import com.example.appselect.data.models.MovieResponse

interface NetworkStorage {

    suspend fun getMovies(offset: Int): MovieResponse
}