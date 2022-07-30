package com.example.appselect.data.storage.retrofit

import com.example.appselect.data.models.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesApi {

    //https://api.nytimes.com/svc/movies/v2/reviews/all.json?&api-key=YourApiKey
    @GET("reviews/all.json?")
    suspend fun getMovies(
        @Query("offset") offset: Int = 0,
        @Query("api-key") apiKey: String = RetrofitClient.API_KEY
    ): MovieResponse


}