package com.motilaloswal.motilaltask.login.loginViewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.motilaloswal.motilaltask.login.loginRepository.LoginRepository

class LoginViewModel(username: String, password: String) :
    ViewModel() {

    private var loginSuccess: MutableLiveData<Boolean>? = null
    private var loginRepository: LoginRepository = LoginRepository()

    init {
        loginSuccess = loginRepository.loginStatus
        loginRepository.getLoginState(username, password)
    }

    fun getLoginRepository(): LiveData<Boolean>? {
        return loginSuccess
    }

}