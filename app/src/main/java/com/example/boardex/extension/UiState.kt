package com.example.boardex.extension

import com.example.boardex.data.response.ResponseGetUserDto

sealed class UiState {
    data object Loading: UiState()
    data class Success(var user: ResponseGetUserDto) : UiState()
    data object Error: UiState()
}