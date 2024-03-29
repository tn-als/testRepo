package com.example.boardex.presentation.makeboard

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.boardex.domain.repository.AuthRepository
import com.example.boardex.extension.MainState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow<MainState>(MainState.Loading)
    val mainState: StateFlow<MainState> = _mainState.asStateFlow()

    fun submitData(title: String, content: String, writerId: Int) {
        viewModelScope.launch {
            try{
                val response=authRepository.makeBoard(title,content,writerId)
                if(response.isSuccess)
                _mainState.value=MainState.Success
                else{
                    response.recoverCatching {
                        if(it is HttpException){
                            val data=it.response()?.errorBody()?.byteString()?.toString()
                            val errorBody = data?.substringAfter("message")
                            if (errorBody != null) {
                                Log.e("error", "mesage${errorBody}")
                            }
                            _mainState.value=MainState.Error
                        }
                    }
                }
            } catch (e:HttpException){
                val data=e.response()?.errorBody()?.byteString()?.toString()
                val errorBody = data?.substringAfter("message")
                if (errorBody != null) {
                    Log.e("error", errorBody)
                }
                _mainState.value=MainState.Error
            }
            /*authRepository.makeBoard(title, content, writerId).onSuccess { response ->
                _mainState.value = MainState.Success(response)
                Log.d("Success", "Success")
            }.onFailure {
                _mainState.value = MainState.Error
                Log.e("Failure", "Failed due to: ${it.message}", it)
            }*/
        }
    }
}
