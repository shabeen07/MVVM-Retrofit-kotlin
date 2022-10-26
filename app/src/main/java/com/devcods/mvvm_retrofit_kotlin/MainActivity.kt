package com.devcods.mvvm_retrofit_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.devcods.mvvm_retrofit_kotlin.view_models.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]

        userViewModel.users.observe(this, Observer { users ->
            println("DEBUG USERS: $users")
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        userViewModel.cancelJobs()
    }
}