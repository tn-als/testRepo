package com.example.boardex.pre

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boardex.data.ServicePool.authService
import com.example.boardex.data.request.RequestMakingBoardDto
import com.example.boardex.domain.repository.AuthRepository
import com.example.boardex.extension.MainState
import com.example.boardex.extension.UiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

//@HiltViewModel
class MainViewModel () : ViewModel() {

    private val _mainState = MutableStateFlow<MainState>(MainState.Loading)
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    fun submitData(title: String, content: String) {
        /*viewModelScope.launch {
            authRepository.makeBoard(title, content).onSuccess { response ->
                _mainState.value = MainState.Success(response)
            }.onFailure {
                _mainState.value = MainState.Error
            }
        }*/
        viewModelScope.launch {
            kotlin.runCatching {
                authService.makeBoard(RequestMakingBoardDto(title, content, 1))
            }.onSuccess {
                if (it.isSuccessful) {
                    _mainState.value = MainState.Success(it.body()!!)
                    Log.d("Success", "Success")
                } else {
                    val errorBody = it.errorBody()?.string()
                    Log.e("fail", "fail - $errorBody")
                    _mainState.value= MainState.Error
                }
            }.onFailure {

            }
        }
    }
}
