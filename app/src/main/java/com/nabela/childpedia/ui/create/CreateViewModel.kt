package com.nabela.childpedia.ui.create

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.EncyclopediaEntity

class CreateViewModel: ViewModel() {
    val encyclopediaViewModel = MutableLiveData<ArrayList<EncyclopediaEntity>>()

    fun getEncyclopedia(): LiveData<ArrayList<EncyclopediaEntity>> {
        return encyclopediaViewModel
    }}