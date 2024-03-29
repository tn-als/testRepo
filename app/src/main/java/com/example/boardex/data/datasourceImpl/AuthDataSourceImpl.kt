/*
package com.example.boardex.data.datasourceImpl

import com.example.boardex.data.datasource.AuthDataSource
import com.example.boardex.data.request.RequestMakingBoardDto
import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import com.example.boardex.data.service.AuthService
import javax.inject.Inject

class AuthDataSourceImpl @Inject constructor(
    private val authService: AuthService,
): AuthDataSource {
    override suspend fun makeBoard(title: String, content:String): ResponseMakeBoardDto<String>
    = authService.makeBoard(
        RequestMakingBoardDto(title, content, 1)
    )

    override suspend fun getUser(id: Int): ResponseGetUserDto
    = authService.getUsers(id)
}
*/
