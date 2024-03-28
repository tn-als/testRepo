package com.example.boardex.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body

@Serializable
data class ResponseMakeBoardDto<T>(
    @SerialName("isSuccess")
    val isSuccess:Boolean,
    @SerialName("code")
    val code: String,
    @SerialName("message")
    val message: String,
    @SerialName("data")
    val data: T
)
