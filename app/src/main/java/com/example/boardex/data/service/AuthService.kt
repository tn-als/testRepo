package com.example.boardex.data.service

import com.example.boardex.data.request.RequestMakingBoardDto
import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path
import java.util.Objects

interface AuthService {
    @GET("/users/{id}")
    suspend fun getUsers(
        @Path("id") id:Int
    ): ResponseGetUserDto

    @POST("/board")
    suspend fun makeBoard(
        @Body request:RequestMakingBoardDto
    ): ResponseMakeBoardDto
}