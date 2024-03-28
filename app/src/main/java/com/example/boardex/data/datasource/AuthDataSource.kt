package com.example.boardex.data.datasource

import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto

interface AuthDataSource {
    suspend fun makeBoard(
        title: String, content:String
    ): ResponseMakeBoardDto<String>

    suspend fun getUser(
        id: Int
    ): ResponseGetUserDto
}