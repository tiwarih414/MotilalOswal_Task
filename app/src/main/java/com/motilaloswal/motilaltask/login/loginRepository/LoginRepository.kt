package com.motilaloswal.motilaltask.login.loginRepository

import androidx.lifecycle.MutableLiveData
import com.motilaloswal.motilaltask.constant.Constant

class LoginRepository {

    var loginStatus: MutableLiveData<Boolean> = MutableLiveData()

    fun getLoginState(username: String, password: String) {
        loginStatus.value = username == Constant.username && password == Constant.password
    }

}