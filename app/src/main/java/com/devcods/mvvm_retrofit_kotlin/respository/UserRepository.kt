package com.devcods.mvvm_retrofit_kotlin.respository

import androidx.lifecycle.LiveData
import com.devcods.mvvm_retrofit_kotlin.api.ApiBuilder
import com.devcods.mvvm_retrofit_kotlin.models.User
import kotlinx.coroutines.*

object UserRepository {

    var job: CompletableJob? = null

    fun getUser(id :Int): LiveData<User>{
        job = Job()
        return object: LiveData<User>(){
            override fun onActive() {
                super.onActive()
                job?.let { job1 ->
                    CoroutineScope(Dispatchers.IO + job1).launch {
                        val user = ApiBuilder.apiService.getUser(id)
                        withContext(Dispatchers.Main){
                            value = user
                            job1.complete()
                        }
                    }
                }
            }
        }
    }

    fun getUsers(): LiveData<List<User>>{
        job = Job()
        return object: LiveData<List<User>>(){
            override fun onActive() {
                super.onActive()
                job?.let { job1 ->
                    CoroutineScope(Dispatchers.IO + job1).launch {
                     val users = ApiBuilder.apiService.getUsers()
                        withContext(Dispatchers.Main){
                            value = users
                            job1.complete()
                        }
                    }
                }
            }
        }
    }

    fun cancelJobs(){
        job?.cancel()
    }

}