package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class AchievementEntity(
    var id: String? = null,
    var name: String? = null,
    var description: String? = null,
    var image: String? = null,
    var updatedAt: String? = null,
    var createdAt: String? = null
):Parcelable