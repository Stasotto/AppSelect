package com.example.appselect.presentation.di

import com.example.appselect.data.di.DataModule
import com.example.appselect.domain.di.DomainModule
import dagger.Module

@Module(includes = [DomainModule::class, DataModule::class])
class AppModule() {
}