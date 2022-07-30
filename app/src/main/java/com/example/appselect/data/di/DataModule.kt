package com.example.appselect.data.di

import com.example.appselect.data.MovieRepositoryImpl
import com.example.appselect.data.storage.NetworkStorage
import com.example.appselect.data.storage.retrofit.MoviesApi
import com.example.appselect.data.storage.retrofit.NetworkStorageImpl
import com.example.appselect.data.storage.retrofit.RetrofitClient
import com.example.appselect.domain.repository.MovieRepository
import dagger.Binds
import dagger.Module
import dagger.Provides

@Module(includes = [DataBindModule::class])
class DataModule {

    @Provides
    fun provideMovieRepository(networkStorage: NetworkStorage): MovieRepository =
        MovieRepositoryImpl(networkStorage)


    @Provides
    fun provideMoviesApi() = RetrofitClient.getMoviesApi()

    @Provides
    fun provideNetworkStorageImpl(api: MoviesApi) = NetworkStorageImpl(api)
}

@Module
interface DataBindModule {
    @Suppress("FunctionName")
    @Binds
    fun bindNetworkStorageImpl_to_NetworkStorage(storage: NetworkStorageImpl): NetworkStorage
}