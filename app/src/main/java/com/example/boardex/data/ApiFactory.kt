package com.example.boardex.data

import com.example.boardex.BuildConfig
import com.example.boardex.data.service.AuthService
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit

object ApiFactory {
    private const val BASE_URL = BuildConfig.BASE_URL

    val retrofit: Retrofit by lazy{
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .build()
    }

    inline fun <reified T> create(): T = retrofit.create<T>(T::class.java)
}


object ServicePool {
    val authService = ApiFactory.create<AuthService>()
}
