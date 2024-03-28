package com.example.boardex.data.request

import kotlinx.serialization.SerialName

@kotlinx.serialization.Serializable
data class RequestMakingBoardDto(
    @SerialName("title")
    val title: String,
    @SerialName("content")
    val content: String,
    @SerialName("writerId")
    val writerId: Int
)