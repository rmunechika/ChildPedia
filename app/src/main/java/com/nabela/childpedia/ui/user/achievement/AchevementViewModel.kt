package com.nabela.childpedia.ui.user.achievement

import androidx.lifecycle.ViewModel
import com.nabela.childpedia.data.entity.AchievementEntity
import com.nabela.childpedia.utils.DummyData

class AchevementViewModel : ViewModel() {
    fun getAchievement(): List<AchievementEntity> = DummyData.generateDummyAchievement()
}