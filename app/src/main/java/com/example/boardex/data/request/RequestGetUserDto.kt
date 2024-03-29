package com.example.boardex.data.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class RequestGetUserDto (
    @SerialName("id")
    val id:Int,
)