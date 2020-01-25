package com.motilaloswal.motilaltask.splash

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.motilaloswal.motilaltask.R
import com.motilaloswal.motilaltask.home.HomeActivity
import com.motilaloswal.motilaltask.login.LoginActivity

class SplashActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var userName: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        init()
    }

    private fun init() {
        sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
        userName = sharedPreferences.getString("userName", "")

        Handler().postDelayed({
            if (userName != "") {
                startActivity(Intent(this@SplashActivity, HomeActivity::class.java))
            } else {
                startActivity(Intent(this@SplashActivity, LoginActivity::class.java))
            }
            finish()
        }, 1000)
    }
}
