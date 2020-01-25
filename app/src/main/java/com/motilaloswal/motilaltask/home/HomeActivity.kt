package com.motilaloswal.motilaltask.home

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.os.Handler
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.motilaloswal.motilaltask.R
import com.motilaloswal.motilaltask.login.LoginActivity
import kotlinx.android.synthetic.main.activity_home.*


class HomeActivity : AppCompatActivity() {

    lateinit var sharedPreferences: SharedPreferences
    lateinit var editor: SharedPreferences.Editor
    var userName = ""

    var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        init()
    }

    private fun init() {
        setSupportActionBar(toolbar)

        sharedPreferences = this.getSharedPreferences("Details", Context.MODE_PRIVATE)
        editor = sharedPreferences.edit()
        userName = sharedPreferences.getString("userName", "").toString()

        tv_show_username.text = "Hello $userName"
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.home_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_logout -> performLogout()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun performLogout() {
        startActivity(Intent(this@HomeActivity, LoginActivity::class.java))
        editor.remove("userName")
        editor.apply()
        finish()
    }

    override fun onBackPressed() {
        if (doubleBackToExitPressedOnce) {
            super.onBackPressed()
            return
        }
        doubleBackToExitPressedOnce = true
        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show()

        Handler().postDelayed(Runnable { doubleBackToExitPressedOnce = false }, 2000)
    }
}
