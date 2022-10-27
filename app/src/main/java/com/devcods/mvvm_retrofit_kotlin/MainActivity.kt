package com.devcods.mvvm_retrofit_kotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.devcods.mvvm_retrofit_kotlin.adapters.UserAdapter
import com.devcods.mvvm_retrofit_kotlin.models.User
import com.devcods.mvvm_retrofit_kotlin.view_models.UserViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var userViewModel: UserViewModel
    private lateinit var rvUsers: RecyclerView
    private lateinit var userAdapter: UserAdapter
    private var userList: List<User> = ArrayList()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUi()
        userViewModel = ViewModelProvider(this)[UserViewModel::class.java]
        userViewModel.users.observe(this, Observer { users ->
            println("DEBUG USERS: $users")
            userList = users
            userAdapter.addAll(userList)
            userAdapter.notifyDataSetChanged()
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        userViewModel.cancelJobs()
    }

    private fun initUi(){
        rvUsers = this.findViewById(R.id.rv_users)
        rvUsers.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        rvUsers.itemAnimator = DefaultItemAnimator()
       // rvUsers.addItemDecoration(DividerItemDecoration(this,DividerItemDecoration.VERTICAL))
        userAdapter = UserAdapter(userList,applicationContext)
        rvUsers.adapter = userAdapter
    }
}