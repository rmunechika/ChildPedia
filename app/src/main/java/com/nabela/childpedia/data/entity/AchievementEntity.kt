package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AchievementEntity(
    var id: Int,
    var name: String,
    var category: String,
    var description: String?,
    var image: String?,
    var updatedAt: String?,
    var createdAt: String?
):Parcelable