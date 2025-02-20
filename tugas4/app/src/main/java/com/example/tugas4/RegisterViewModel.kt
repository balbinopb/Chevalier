package com.example.tugas4

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class RegisterViewModel : ViewModel() {
    private val _username= MutableStateFlow("")
    val username= _username.asStateFlow()

    private val _email= MutableStateFlow("")
    val email= _email.asStateFlow()

    private val _password= MutableStateFlow("")
    val password= _password.asStateFlow()

    private val _passwordVisible= MutableStateFlow(false)
    val passwordVisible=_passwordVisible.asStateFlow()



    fun updateUsername(newUsername: String) {
        _username.value = newUsername
    }

    fun updateEmail(newEmail: String) {
        _email.value = newEmail
    }

    fun updatePassword(newPassword: String){
        _password.value=newPassword
    }

    fun togglePasswordVisibility() {
        _passwordVisible.value = !_passwordVisible.value
    }


}