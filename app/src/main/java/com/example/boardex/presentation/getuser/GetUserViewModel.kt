package com.example.boardex.presentation.getuser

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boardex.data.ServicePool.authService
import com.example.boardex.data.response.ResponseGetUserDto
import com.example.boardex.domain.repository.AuthRepository
import com.example.boardex.extension.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class GetUserViewModel() : ViewModel() {
    val getSuccess: MutableLiveData<Boolean> = MutableLiveData()

    private var _getResult : MutableLiveData<ResponseGetUserDto> = MutableLiveData()
    val getResult : MutableLiveData<ResponseGetUserDto> = _getResult

    private val _getState = MutableStateFlow<UiState>(UiState.Loading)
    var getState: StateFlow<UiState> = _getState.asStateFlow()

    fun getUser(id: Int) {
        /*viewModelScope.launch {
            authRepository.getUser(id).onSuccess {response ->
                _getState.value=UiState.Success(response)
            }.onFailure {
                _getState.value=UiState.Error
            }
        }*/
         viewModelScope.launch {
            kotlin.runCatching {
                authService.getUsers(id)
            }.onSuccess {
                if(it.isSuccessful) {
                    _getResult.value=it.body()
                    _getState.value=UiState.Success(it.body()!!)
                    Log.d("success", "name: ${_getResult.value?.username}")
                }else{
                    val errorBody = it.errorBody()?.string()
                    Log.e("fail", "fail - $errorBody")
                    _getState.value=UiState.Error
                }
            }.onFailure {

            }
        }
    }

}
