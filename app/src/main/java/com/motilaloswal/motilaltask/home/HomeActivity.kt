package com.motilaloswal.motilaltask.home

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.motilaloswal.motilaltask.R
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    var userName = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {

        sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
        userName = sharedPreferences.getString("userName", "").toString()

        tv_show_username.text = "Hello $userName"
    }
}
