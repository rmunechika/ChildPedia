package com.nabela.childpedia.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.utils.DummyData

class HomeViewModel : ViewModel() {
    fun getEncyclopedia(): List<EncyclopediaEntity> = DummyData.generateDummyEncyclopedia()
}
