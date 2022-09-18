package com.example.belajar_sharedviewmodel.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.belajar_sharedviewmodel.model.UserModel

class SharedMainViewModel:ViewModel() {

    private val emptyUser = UserModel("unknown",0)
    private var _user:MutableLiveData<UserModel> = MutableLiveData(emptyUser)
    val user:LiveData<UserModel> = _user

    fun setUser(param:UserModel){
        _user.value = param
    }

    fun clearUser(){
        _user.value = emptyUser
    }
}