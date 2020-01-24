package com.motilaloswal.motilaltask.login.loginViewModelFactory

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.motilaloswal.motilaltask.login.loginViewModel.LoginViewModel

class LoginViewModelFactory(var username: String, var password: String) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return LoginViewModel(username, password) as T
    }
}