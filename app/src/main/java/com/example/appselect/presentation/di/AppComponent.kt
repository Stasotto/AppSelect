package com.example.appselect.presentation.di

import com.example.appselect.presentation.MainActivity
import dagger.Component
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview

@Component(modules = [AppModule::class])
interface AppComponent {

    @FlowPreview
    @ExperimentalCoroutinesApi
    fun inject(activity: MainActivity)
}