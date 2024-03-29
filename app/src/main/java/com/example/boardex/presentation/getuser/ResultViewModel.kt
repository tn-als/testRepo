package com.example.boardex.presentation.getuser

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ResultViewModel: ViewModel() {
    private var _name: MutableLiveData<String?> = MutableLiveData()
    val name: LiveData<String?> get() = _name

    fun setName(name: String){
        _name.value=name
    }
}