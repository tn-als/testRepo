package com.example.boardex.di

import com.example.boardex.data.service.AuthService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ServiceModule {
    @Provides
    @Singleton
    fun provideMockService(retrofit: Retrofit):AuthService =
        retrofit.create(AuthService::class.java)
}