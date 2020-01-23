package com.motilaloswal.motilaltask.login

import android.os.Bundle
import android.text.TextUtils
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motilaloswal.motilaltask.R
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        initView()
    }

    private fun initView() {
        btnLogin.setOnClickListener {
            if (!checkEmpty()) {

            }
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
