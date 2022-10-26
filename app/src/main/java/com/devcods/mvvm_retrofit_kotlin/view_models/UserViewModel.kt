package com.devcods.mvvm_retrofit_kotlin.view_models

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import androidx.lifecycle.ViewModel
import com.devcods.mvvm_retrofit_kotlin.models.User
import com.devcods.mvvm_retrofit_kotlin.respository.UserRepository

class UserViewModel : ViewModel() {

    private val _userId : MutableLiveData<Int> = MutableLiveData()

    val user: LiveData<User> = Transformations.switchMap(_userId){ id ->
            UserRepository.getUser(id)
    }

    fun setUserId(userId: Int) {
        if (_userId.value == userId) {
            return
        }
        _userId.value = userId
    }


    val users : LiveData<List<User>> = UserRepository.getUsers()

    fun cancelJobs() {
        UserRepository.cancelJobs()
    }

}