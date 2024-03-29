package com.example.boardex.data.repositoryImpl

import android.net.http.HttpException
import android.util.Log
import com.example.boardex.data.datasource.AuthDataSource
import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.data.response.ResponseMakeBoardDto
import com.example.boardex.domain.repository.AuthRepository
import java.util.Objects
import javax.inject.Inject

class AuthRepositoryImpl @Inject constructor(
    private val authDataSource: AuthDataSource
) : AuthRepository {
    override suspend fun makeBoard(
        title: String,
        content: String,
        writerId: Int
    ): Result<ResponseMakeBoardDto> {
        return runCatching {
            authDataSource.makeBoard(title, content, writerId)
        }
    }

    override suspend fun getUser(id: Int): Result<ResponseGetUserDto> {
        return runCatching {
            authDataSource.getUser(id)
        }
    }
}
