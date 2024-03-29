package com.example.boardex.data.datasource

import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import java.util.Objects

interface AuthDataSource {
    suspend fun makeBoard(
        title: String, content:String, writerId:Int,
    ): ResponseMakeBoardDto

    suspend fun getUser(
        id: Int
    ): ResponseGetUserDto
}