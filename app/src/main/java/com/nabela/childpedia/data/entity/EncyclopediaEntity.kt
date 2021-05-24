package com.nabela.childpedia.data.entity

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
class EncyclopediaEntity(
    var title: String? = null,
    var description: String? = null,
    var image: String? = null,
    var likes: Int? = 0,
    var comments: Int? = 0
) : Parcelable