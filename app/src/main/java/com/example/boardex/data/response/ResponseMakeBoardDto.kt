package com.example.boardex.data.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import retrofit2.http.Body

@Serializable
data class ResponseMakeBoardDto(
    @SerialName("success")
    val success: Boolean,
    @SerialName("status")
    val status: String,
    @SerialName("message")
    val message: String,
   /* @SerialName("data")
    val data: T*/
)

fun ResponseMakeBoardDto.handleResponse() {
    if (!success) {
        println(message)
    }
}