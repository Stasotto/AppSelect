package com.example.appselect.data.storage.retrofit

import com.google.gson.GsonBuilder
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitClient {

    const val API_KEY = "YourApiKey"
    private const val BASE_URL = "https://api.nytimes.com/svc/movies/v2/"


    private val gson = GsonBuilder()
        .setLenient()
        .create()

    fun getMoviesApi(): MoviesApi = getClient().create(MoviesApi::class.java)

    private fun getClient() = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .build()
}
