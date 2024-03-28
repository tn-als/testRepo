/*
package com.example.boardex.data.repositoryImpl

import com.example.boardex.data.datasource.AuthDataSource
import com.example.boardex.data.request.RequestMakingBoardDto
import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import com.example.boardex.domain.repository.AuthRepository
import retrofit2.Response
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun makeBoard(title:String, content: String): Result<ResponseMakeBoardDto<String>> {
        return runCatching {
            authDataSource.makeBoard(title, content)
        }
    }

    override suspend fun getUser(id: Int): Result<ResponseGetUserDto> {
        return runCatching {
            authDataSource.getUser(id)
        }
    }
}
*/
