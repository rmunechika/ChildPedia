package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AchievementEntity(
    var image: String,
    var name: String,
    var description: String

):Parcelable