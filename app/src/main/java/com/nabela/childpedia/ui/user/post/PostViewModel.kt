package com.nabela.childpedia.ui.user.post

import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.EncyclopediaEntity
import com.nabela.childpedia.utils.DummyData

class PostViewModel : ViewModel() {
    fun getEncyclopedia(): List<EncyclopediaEntity> = DummyData.generateDummyEncyclopedia()
}