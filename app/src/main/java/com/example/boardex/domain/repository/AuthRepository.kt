package com.example.boardex.domain.repository

import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import java.util.Objects

interface AuthRepository {
    suspend fun makeBoard(
        title: String, content: String, writerId: Int,
    ): Result<ResponseMakeBoardDto>

    suspend fun getUser(
        id: Int
    ): Result<ResponseGetUserDto>
}
