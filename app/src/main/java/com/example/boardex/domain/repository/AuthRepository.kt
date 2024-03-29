package com.example.boardex.domain.repository

import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto

interface AuthRepository {
    suspend fun makeBoard(
        title: String, content: String
    ): Result<ResponseMakeBoardDto<String>>

    suspend fun getUser(
        id: Int
    ): Result<ResponseGetUserDto>
}
