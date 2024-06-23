package com.task.ecommercebluefunder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.task.ecommercebluefunder.repository.auth.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AuthViewModel @Inject constructor(private val authRepository: AuthRepository):ViewModel() {

private val _LOGIN_STATUES :MutableStateFlow<Boolean> = MutableStateFlow(false)
    val LOGIN_STATUES get() = _LOGIN_STATUES

    init {
        viewModelScope.launch {
            updateLoginState(false)
            getLoginStatues()
        }
    }

private suspend fun getLoginStatues()
{
    viewModelScope.launch {
         authRepository.getLoginStatues().collect{
             _LOGIN_STATUES.value = it
         }
    }
}

    private suspend fun updateLoginState(state:Boolean){
        viewModelScope.launch {
            authRepository.UpdateLoginStatues(state)
        }
    }



}