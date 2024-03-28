package com.example.boardex.extension

import com.example.boardex.data.response.ResponseMakeBoardDto

sealed class MainState{
    data object Loading: MainState()
    data class Success(var user: ResponseMakeBoardDto<String>) : MainState()
    data object Error: MainState()
}
