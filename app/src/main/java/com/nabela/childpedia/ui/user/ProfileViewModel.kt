package com.nabela.childpedia.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.data.entity.UserEntity

class ProfileViewModel: ViewModel() {
    val userViewModel = MutableLiveData<ArrayList<UserEntity>>()

    fun getUser(): LiveData<ArrayList<UserEntity>> {
        return userViewModel
    }}