package com.motilaloswal.motilaltask.login

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.motilaloswal.motilaltask.R
import com.motilaloswal.motilaltask.home.HomeActivity
import com.motilaloswal.motilaltask.login.loginViewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var loginViewModel: LoginViewModel
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        init()
    }

    private fun init() {
        sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()

        loginViewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        loginViewModel.getLoginRepository()?.observe(this, Observer {
            checkState(it)
        })

        btnLogin.setOnClickListener {
            if (!checkEmpty()) {
                loginViewModel.onLoginDataUpdate(et_username.text.toString().trim(), et_password.text.toString())
            }
        }
    }

    private fun checkState(checkState: Boolean) {
        if (checkState) {
            startActivity(Intent(this@LoginActivity, HomeActivity::class.java))
            editor.putString("userName", et_username.text.toString())
            editor.apply()
            finish()
        } else {
            Toast.makeText(this, "Invalid Credentials", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkEmpty(): Boolean {
        var result = false
        if (TextUtils.isEmpty(et_username.text.toString())) {
            Toast.makeText(this, "Please Enter Username", Toast.LENGTH_SHORT).show()
            et_username.requestFocus()
            result = true
        } else if (TextUtils.isEmpty(et_password.text.toString())) {
            Toast.makeText(this, "Please Enter Password", Toast.LENGTH_SHORT).show()
            et_password.requestFocus()
            result = true
        }
        return result
    }
}
