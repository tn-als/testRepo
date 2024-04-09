package com.example.boardex.extension

import com.example.boardex.data.response.ResponseMakeBoardDto
import java.util.Objects

sealed class MainState{
    data object Loading: MainState()
    data class Success(var user: ResponseMakeBoardDto) : MainState()
    data object Error: MainState()
}
